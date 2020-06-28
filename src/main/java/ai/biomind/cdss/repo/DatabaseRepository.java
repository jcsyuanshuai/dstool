package ai.biomind.cdss.repo;

import ai.biomind.cdss.domain.MyDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<MyDatabase, Long> {
}
