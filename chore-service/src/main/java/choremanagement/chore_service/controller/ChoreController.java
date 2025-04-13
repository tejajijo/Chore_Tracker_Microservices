package choremanagement.chore_service.controller;

import choremanagement.chore_service.model.Chore;
import choremanagement.chore_service.service.ChoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chores")
public class ChoreController {

    public ChoreService choreService;

    public ChoreController(ChoreService choreService) {
        this.choreService = choreService;
    }

    @GetMapping
    public ResponseEntity<List<Chore>> getAllChores() {
        return ResponseEntity.ok(choreService.getAllChores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chore> getChoreById(@PathVariable int id) {
        return ResponseEntity.ok(choreService.getChoreById(id));
    }

    @PostMapping
    public ResponseEntity<Chore> createChore(@RequestBody Chore chore) {
        return ResponseEntity.ok(choreService.createChore(chore));
    }

    @PutMapping
    public ResponseEntity<Chore> updateChore(@RequestBody Chore chore) {
        return ResponseEntity.ok(choreService.updateChore(chore));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChore(@PathVariable int id) {
        choreService.deleteChore(id);
        return ResponseEntity.noContent().build();
    }
}
