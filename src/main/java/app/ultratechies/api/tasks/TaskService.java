package app.ultratechies.api.tasks;

import app.ultratechies.api.AppUsers.AppUser;
import app.ultratechies.api.AppUsers.UserService;
import app.ultratechies.api.exceptions.TaskNotfoundException;
import app.ultratechies.api.utils.DateTimeUtil;
import lombok.*;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class TaskService {

    final TaskRepository taskRepository;
    final UserService userService;

    Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task convertDTOtoTask(Long userId,TaskDTO dto){

        return  Task.builder()
                .title(dto.getTitle())
                .description(dto.description)
                .userId(userId)
                .date(DateTimeUtil.convertStringToInstant(dto.getDate()))
                .appUser(userService.getAppUser(userId))
                .status(TaskStatus.created)
                .build();
    }

    public Task createTaskAndSave(Long userId,TaskDTO dto){
        Task newTask = convertDTOtoTask(userId,dto);
        return save(newTask);
    }

    public TaskDTO convertTaskToTaskDTO(Task task){
        return TaskDTO.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .date(DateTimeUtil.convertInstantToString(task.getDate()))
                .status(task.getStatus().toString())
                .build();
    }

    public Task updateTask(Long id, TaskDTO dto){
        Optional<Task> task = taskRepository.findById(id);
        Task updatedTask = null; //TODO add exception to prevent possible null pointer exception
        if(task.isPresent()){
            updatedTask = task.get();
            updatedTask.setTitle(dto.getTitle());
            updatedTask.setDescription(dto.getDescription());
            updatedTask.setDate(DateTimeUtil.convertStringToInstant(dto.getDate()));
            updatedTask.setStatus(TaskStatus.valueOf(dto.getStatus()));

        }
        return updatedTask;
    }

    public Task updateTaskAndSave(Long id, TaskDTO dto){
        return save(updateTask(id,dto));
    }

    public Optional<List<Task>> getTaskByUserId(Long id){
        Optional<AppUser> user = userService.getUsersById(id);
        if(user.isPresent()){
        return taskRepository.findAllByUserId(id);}
        else return Optional.empty();
    }

    public Task findByIdOrThrow(Long taskId){
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotfoundException("Task does not exist"));
    }

    public void deleteTask(Long taskId){
        findByIdOrThrow(taskId);
        taskRepository.deleteById(taskId);
    }
}