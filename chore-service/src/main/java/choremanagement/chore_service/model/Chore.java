package choremanagement.chore_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="chores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chore_Id")
    private int choreId;

    @Column(name = "chor_Name", nullable = false)
    private String chore_Name;

    @OneToMany(mappedBy = "chore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubChore> subChores;

}
