package ai.biomind.cdss.repo;

import ai.biomind.cdss.domain.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<MyTask, Long> {
    //    @Query("select * from my_task where job_id = ？1")
    List<MyTask> findByJobId(Long id);

}
