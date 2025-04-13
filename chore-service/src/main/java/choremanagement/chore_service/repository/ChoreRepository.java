package choremanagement.chore_service.repository;

import choremanagement.chore_service.model.Chore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoreRepository extends JpaRepository<Chore, Integer> {

}

