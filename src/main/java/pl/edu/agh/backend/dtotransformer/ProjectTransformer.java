package pl.edu.agh.backend.dtotransformer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.struct.Project;
import pl.edu.agh.backend.struct.Task;
import pl.edu.agh.backend.struct.User;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class ProjectTransformer {

   private final ModelMapper modelMapper;
   private final UserTransformer userTransformer;
   private final TaskTransformer taskTransformer;

   @Autowired
   public ProjectTransformer(ModelMapper modelMapper, UserTransformer userTransformer,
         TaskTransformer taskTransformer) {
      this.modelMapper = modelMapper;
      this.userTransformer = userTransformer;
      this.taskTransformer = taskTransformer;
   }

   public Project transformFromDto(ProjectDto dto) {
      Project entity = modelMapper.map(dto, Project.class);
      List<Project> subProjectList = new LinkedList<>();
      List<User> users = new LinkedList<>();
      Set<Task> tasks = new HashSet<>();
      dto.getSubProjects().forEach(projectDto -> subProjectList.add(transformFromDto(projectDto)));
      dto.getUsers().forEach(userDto -> users.add(userTransformer.tranformFromDto(userDto)));
      dto.getTasks().forEach(taskDto -> tasks.add(taskTransformer.transformFromDto(taskDto)));
      entity.setUsers(users);
      entity.setTasks(tasks);
      entity.setSubProjets(subProjectList);
      if (dto.getParentProject() != null) {
         entity.setParentProject(transformFromDto(dto.getParentProject()));
      }
      return entity;
   }

   public ProjectDto transformToDto(Project entity) {
      ProjectDto dto = modelMapper.map(entity, ProjectDto.class);
      List<ProjectDto> subProjectList = new LinkedList<>();
      List<UserDto> users = new LinkedList<>();
      Set<TaskDto> tasks = new HashSet<>();
      entity.getSubProjets().forEach(project -> subProjectList.add(transformToDto(project)));
      entity.getUsers().forEach(user -> users.add(userTransformer.transformToDto(user)));
      entity.getTasks().forEach(task -> tasks.add(taskTransformer.transformToDto(task)));
      dto.setUsers(users);
      dto.setTasks(tasks);
      dto.setSubProjects(subProjectList);
      if (dto.getParentProject() != null) {
         dto.setParentProject(transformToDto(entity.getParentProject()));
      }
      return dto;
   }
}
