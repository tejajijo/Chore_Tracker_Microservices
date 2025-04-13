package choremanagement.chore_service.service;

import choremanagement.chore_service.model.Chore;
import choremanagement.chore_service.repository.ChoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoreService {

    private ChoreRepository choreRepository;

    public ChoreService(ChoreRepository choreRepository) {
        this.choreRepository = choreRepository;
    }

    public List<Chore> getAllChores() {
        return choreRepository.findAll();
    }

    public Chore getChoreById(int id) {
        return choreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chore not found"));
    }

    public Chore createChore(Chore chore) {
        return choreRepository.save(chore);
    }

    public Chore updateChore(Chore chore) {
        Chore existingChore = choreRepository.findById(chore.getChoreId())
                .orElseThrow(() -> new RuntimeException("Chore not found"));

        existingChore.setChore_Name(chore.getChore_Name());
        return choreRepository.save(existingChore);
    }

    public void deleteChore(int id) {
        choreRepository.deleteById(id);
    }
}
