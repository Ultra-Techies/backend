package app.ultratechies.api.tasks;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    final TaskService taskService;

    @ApiOperation("Get All Tasks By User ID")
    @GetMapping("/{id}")
    public ResponseEntity <List<TaskDTO>> getTaskByUserId(@PathVariable Long id){
        var task = taskService.getTaskByUserId(id);
        return ResponseEntity.ok(task);
    }

    @ApiOperation("Create New Task By User ID")
    @PostMapping("/add/{userId}")
    public ResponseEntity<TaskDTO> createNewTask(@PathVariable Long userId ,@RequestBody TaskDTO taskDTO){
        ModelMapper modelMapper = new ModelMapper();
        var newTask = taskService.createTaskAndSave(userId,taskDTO);
        TaskDTO dto = modelMapper.map(newTask, TaskDTO.class);
        return ResponseEntity.ok(dto);
    }


    @ApiOperation("Update Task By Task ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        var updateTask = taskService.updateTaskAndSave(id,taskDTO);
        ModelMapper modelMapper = new ModelMapper();
        TaskDTO dto = modelMapper.map(updateTask, TaskDTO.class);
        return ResponseEntity.ok(dto);
    }

    @ApiOperation("Delete Task By Task ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        JSONObject deleteMessage= new JSONObject();
        deleteMessage.put("message","Task deleted successfully!");
        return ResponseEntity.status(HttpStatus.OK).body(deleteMessage.toString());
    }
}
