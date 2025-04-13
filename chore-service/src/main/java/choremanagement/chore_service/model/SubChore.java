package choremanagement.chore_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subchores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubChore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_Id")
    private int task_Id;

    @Column(name = "task_Name", nullable = false)
    private String task_name;

    @ManyToOne
    @JoinColumn(name = "parent_chore_Id", referencedColumnName = "chore_Id")
    @JsonIgnore
    private Chore chore;

    @Column(name = "freequency", nullable = false)
    private String frequency;

}