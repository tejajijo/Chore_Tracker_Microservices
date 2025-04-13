package choremanagement.chore_service.controller;


import choremanagement.chore_service.model.SubChore;
import choremanagement.chore_service.service.SubChoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chores/{choreId}/subchores")
public class SubChoreController {

    private final SubChoreService subChoreService;

    public SubChoreController(SubChoreService subChoreService) {
        this.subChoreService = subChoreService;
    }

    // Get all subchores for a chore
    @GetMapping
    public ResponseEntity<List<SubChore>> getSubChores(@PathVariable int choreId) {
        return ResponseEntity.ok(subChoreService.getSubChoresByChoreId(choreId));
    }

    // Create a subchore for a specific chore
    @PostMapping
    public ResponseEntity<SubChore> createSubChore(@PathVariable int choreId, @RequestBody SubChore subChore) {
        return ResponseEntity.ok(subChoreService.createSubChore(choreId, subChore));
    }

    // Delete a subchore by ID
    @DeleteMapping("/{subChoreId}")
    public ResponseEntity<Void> deleteSubChore(@PathVariable int subChoreId) {
        subChoreService.deleteSubChore(subChoreId);
        return ResponseEntity.noContent().build();
    }
}