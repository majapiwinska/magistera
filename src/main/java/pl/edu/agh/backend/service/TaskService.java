package pl.edu.agh.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.dtotransformer.TaskTransformer;
import pl.edu.agh.backend.repository.TaskRepository;
import pl.edu.agh.backend.struct.Task;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {

   private final TaskTransformer taskTransformer;
   private final TaskRepository taskRepository;

   @Autowired
   public TaskService(TaskTransformer taskTransformer, TaskRepository taskRepository){
      this.taskRepository = taskRepository;
      this.taskTransformer = taskTransformer;
   }

   public List<TaskDto> getProjectTaskList(Long id){
      TaskDto dto = new TaskDto();
      List<Task> tasks = this.taskRepository.findByProject_Id(id);
      List<TaskDto> dtoList = new LinkedList<>();
      tasks.forEach(task -> dtoList.add(taskTransformer.transformToDto(task)));
      return dtoList;
   }

   public List<TaskDto> getUserTaskList(String username){
      TaskDto dto = new TaskDto();
      List<Task> tasks = this.taskRepository.findByAssignedTo_Username(username);
      List<TaskDto> dtoList = new LinkedList<>();
      tasks.forEach(task -> dtoList.add(taskTransformer.transformToDto(task)));
      return dtoList;
   }

   public TaskDto save(TaskDto taskDto) {
      Task task = new Task();
      task = taskTransformer.transformFromDto(taskDto);
      task = taskRepository.save(task);
      return taskTransformer.transformToDto(task);
   }
}

