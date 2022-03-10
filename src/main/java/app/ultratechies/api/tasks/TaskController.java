package app.ultratechies.api.tasks;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity <List<TaskDTO>> getTaskByUserId(@PathVariable Long id){
        var task = taskService.getTaskByUserId(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<TaskDTO> createNewTask(@PathVariable Long userId ,@RequestBody TaskDTO taskDTO){
        ModelMapper modelMapper = new ModelMapper();
        var newTask = taskService.createTaskAndSave(userId,taskDTO);
        TaskDTO dto = modelMapper.map(newTask, TaskDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        var updateTask = taskService.updateTaskAndSave(id,taskDTO);
        ModelMapper modelMapper = new ModelMapper();
        TaskDTO dto = modelMapper.map(updateTask, TaskDTO.class);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}