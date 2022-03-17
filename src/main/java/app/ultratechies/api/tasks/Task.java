package app.ultratechies.api.tasks;



import app.ultratechies.api.AppUsers.AppUser;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;



@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    Instant dueDate;
    @Column
    Instant createdTime;
    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @ManyToOne
    private AppUser appUser;

}