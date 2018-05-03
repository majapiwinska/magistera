package pl.edu.agh.backend.dto;

import pl.edu.agh.backend.struct.Project;
import pl.edu.agh.backend.struct.Role;
import pl.edu.agh.backend.struct.Task;
import pl.edu.agh.backend.struct.enums.UserRole;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UserDto {

   private Long id;
   private String firstName;
   private String lastName;
   private String username;
   private String email;
   private int active;
   private String password;
   private List<Task> usersTasks = new LinkedList<>();

   private Set<Role> roles = new HashSet<>();
   private Set<Project> userProjects = new HashSet<>();

   public UserDto() {
   }

   public UserDto(String firstName, String lastName, String username, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = username;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public List<Task> getUsersTasks() {
      return usersTasks;
   }

   public void setUsersTasks(List<Task> usersTasks) {
      this.usersTasks = usersTasks;
   }

   public Set<Project> getUserProjects() {
      return userProjects;
   }

   public void setUserProjects(Set<Project> userProjects) {
      this.userProjects = userProjects;
   }

   public Set<Role> getRoles() {
      return roles;
   }

   public void setRoles(Set<Role> roles) {
      this.roles = roles;
   }

   public int getActive() {
      return active;
   }

   public void setActive(int active) {
      this.active = active;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
