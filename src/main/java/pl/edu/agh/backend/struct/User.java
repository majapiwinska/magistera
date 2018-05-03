package pl.edu.agh.backend.struct;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.edu.agh.backend.struct.enums.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class User implements Serializable {

   private static final long serialVersionUID = -8706487736618634306L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String firstName;
   private String lastName;
   private int active;

   @Column(unique = true)
   private String username;

   private String email;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private String password;


   @ManyToMany
   @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> roles = new HashSet<>();

   @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
   private List<Task> tasks = new LinkedList<>();

   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable(name = "user_projects", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
         @JoinColumn(name = "project_id") })
   private Set<Project> projects = new HashSet<>();

   public User() {
   }

   public User(String firstName, String lastName, String username, String email) {
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

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public List<Task> getTasks() {
      return tasks;
   }

   public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
   }

   public Set<Project> getProjects() {
      return projects;
   }

   public void setProjects(Set<Project> projects) {
      this.projects = projects;
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
}
