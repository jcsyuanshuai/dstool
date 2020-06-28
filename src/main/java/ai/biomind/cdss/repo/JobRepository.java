package ai.biomind.cdss.repo;

import ai.biomind.cdss.domain.MyJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<MyJob, Long> {

    List<MyJob> findByIsActive(Boolean flag);
}
