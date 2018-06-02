package pl.edu.agh.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.dtotransformer.TaskTransformer;
import pl.edu.agh.backend.repository.TaskRepository;
import pl.edu.agh.backend.repository.UserRepository;
import pl.edu.agh.backend.struct.Task;
import pl.edu.agh.backend.struct.User;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {

   private final TaskRepository taskRepository;
   private final UserRepository userRepository;

   private final TaskTransformer taskTransformer = new TaskTransformer();
   @Autowired
   public TaskService( TaskRepository taskRepository, UserRepository userRepository){
      this.taskRepository = taskRepository;
      this.userRepository = userRepository;
   }

 /*  public List<TaskDto> getProjectTaskList(Long id){
      TaskDto dto = new TaskDto();
      List<Task> tasks = this.taskRepository.findByProject_Id(id);
      List<TaskDto> dtoList = new LinkedList<>();
      tasks.forEach(task -> dtoList.add(taskTransformer.transformToDto(task)));
      return dtoList;
   }
*/
   public List<TaskDto> getUserTaskList(String username){
      List<Task> tasks = this .taskRepository.findByAssignedTo_Username(username);
      List<TaskDto> dtoList = new LinkedList<>();
      tasks.forEach(task -> dtoList.add(taskTransformer.transformToDto(task)));
      return dtoList;
   }

   public TaskDto save(TaskDto taskDto) {
      Task task;
      task = taskTransformer.transformFromDto(taskDto);
      task.setAssignedTo(userRepository.findById(taskDto.getUserId()).get());
      task = taskRepository.save(task);
      return taskTransformer.transformToDto(task);
   }
}

