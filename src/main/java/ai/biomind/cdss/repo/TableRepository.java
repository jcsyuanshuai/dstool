package ai.biomind.cdss.repo;

import ai.biomind.cdss.domain.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<MyTable, Long> {
}
