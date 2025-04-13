package choremanagement.chore_service.repository;

import choremanagement.chore_service.model.Chore;
import choremanagement.chore_service.model.SubChore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubChoreRepository extends JpaRepository<SubChore, Integer> {
    List<SubChore> findByChore(Chore chore);
}
