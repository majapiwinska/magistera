package pl.edu.agh.backend.dto;

import java.util.List;
import java.util.Set;

public class ProjectDto {

   private Long id;
   private String name;
   private String description;
   private UserDto owner;

   private List<UserDto> users;

   private Set<TaskDto> tasks;

   private ProjectDto parentProject;
   private List<ProjectDto> subProjects;

   public ProjectDto() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public UserDto getOwner() {
      return owner;
   }

   public void setOwner(UserDto owner) {
      this.owner = owner;
   }

   public List<UserDto> getUsers() {
      return users;
   }

   public void setUsers(List<UserDto> users) {
      this.users = users;
   }

   public Set<TaskDto> getTasks() {
      return tasks;
   }

   public void setTasks(Set<TaskDto> tasks) {
      this.tasks = tasks;
   }

   public ProjectDto getParentProject() {
      return parentProject;
   }

   public void setParentProject(ProjectDto parentProject) {
      this.parentProject = parentProject;
   }

   public List<ProjectDto> getSubProjects() {
      return subProjects;
   }

   public void setSubProjects(List<ProjectDto> subProjects) {
      this.subProjects = subProjects;
   }
}
