package app.ultratechies.api.tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<Task>>> getTaskByUserId(@PathVariable Long id){
        var task = taskService.getTaskByUserId(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<Task> createNewTask(@PathVariable Long userId ,@RequestBody TaskDTO dto){
        var newTask = taskService.createTaskAndSave(userId,dto);
        return ResponseEntity.ok(newTask);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        var updateTask = taskService.updateTaskAndSave(id,taskDTO);
        return ResponseEntity.ok(updateTask);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}