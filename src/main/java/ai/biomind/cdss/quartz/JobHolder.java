package ai.biomind.cdss.quartz;

import ai.biomind.cdss.domain.MyDatabase;
import ai.biomind.cdss.domain.MyJob;
import ai.biomind.cdss.domain.MyTable;
import ai.biomind.cdss.domain.MyTask;
import ai.biomind.cdss.repo.DatabaseRepository;
import ai.biomind.cdss.repo.JobRepository;
import ai.biomind.cdss.repo.TableRepository;
import ai.biomind.cdss.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.List;

public class JobHolder {

    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

    @Autowired
    JobRepository jobRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    DatabaseRepository databaseRepository;
    @Autowired
    TableRepository tableRepository;


    void initJobContext() {
        threadPoolTaskScheduler.setPoolSize(20);
        threadPoolTaskScheduler.initialize();
    }

    void startAll() {
        List<MyJob> jobList = jobRepository.findByIsActive(true);
        for (MyJob job : jobList) {
            List<MyTask> TaskList = taskRepository.findByJobId(job.getId());
            for (MyTask task : TaskList) {
                MyDatabase db = databaseRepository.getOne(task.getDbId());
                MyTable tb = tableRepository.getOne(task.getTbId());
                threadPoolTaskScheduler.schedule(new RunnableTask(task, db, tb), triggerContext -> {
                    CronTrigger cron = new CronTrigger(task.getTrigger());
                    return cron.nextExecutionTime(triggerContext);
                });
            }
        }
    }

    static class RunnableTask implements Runnable {

        RunnableTask(MyTask task, MyDatabase db, MyTable tb) {

        }

        @Override
        public void run() {

        }
    }
}
