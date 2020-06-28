package ai.biomind.cdss.service;

import ai.biomind.cdss.domain.MyTask;
import ai.biomind.cdss.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<MyTask> findByJobId(Long id) {
        return taskRepository.findByJobId(id);
    }

}
