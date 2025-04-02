package choremanagement.user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "user_email", nullable = false, unique = true)
    @JsonProperty("email")
    private String email;

    @Column(name = "user_password", nullable = false)
    @JsonIgnore
    private String password;
}
