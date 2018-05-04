package pl.edu.agh.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

   private final TaskService taskService;

   @Autowired
   public TaskController(TaskService taskService) {
      this.taskService = taskService;
   }

   @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
   public List<TaskDto> getProjectTaksList(@PathVariable Long id){
      return taskService.getProjectTaskList(id);
   }

   //TODO: pobierać po id, nie po username
   @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
   public List<TaskDto> getUserTaskList(@PathVariable String username) {
      return taskService.getUserTaskList(username);
   }

   @RequestMapping(value = "/save", method = RequestMethod.POST)
   public TaskDto saveTask(@RequestBody TaskDto dto){
      return taskService.save(dto);
   }
}
