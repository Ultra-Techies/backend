package app.ultratechies.api.tasks;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    String title;
    String description;
    String date;
    String status;
}