package app.ultratechies.api.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task,Long> {
    List<Task> findAllByAppUser_Id(Long id);
}
