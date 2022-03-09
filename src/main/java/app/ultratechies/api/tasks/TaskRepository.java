package app.ultratechies.api.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository <Task,Long> {

    Optional<List<Task>> findAllByUserId(Long userId);
}
