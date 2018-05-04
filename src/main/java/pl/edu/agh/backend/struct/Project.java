package pl.edu.agh.backend.struct;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class Project implements Serializable {

   private static final long serialVersionUID = 3335216810669041357L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private User owner;

   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "projects")
   private List<User> users = new LinkedList<>();

   @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
   private Set<Task> tasks = new HashSet<>();

   @ManyToOne
   private Project parentProject;

   @OneToMany(mappedBy = "parentProject")
   private List<Project> subProjets = new LinkedList<>();


   public Project() {
   }

   public Project(String name, String description, User owner, List<User> users, Set<Task> tasks) {
      this.name = name;
      this.description = description;
      this.owner = owner;
      this.users = users;
      this.tasks = tasks;
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

   public User getOwner() {
      return owner;
   }

   public void setOwner(User owner) {
      this.owner = owner;
   }

   public List<User> getUsers() {
      return users;
   }

   public void setUsers(List<User> users) {
      this.users = users;
   }

   public Set<Task> getTasks() {
      return tasks;
   }

   public void setTasks(Set<Task> tasks) {
      this.tasks = tasks;
   }

   public Project getParentProject() {
      return parentProject;
   }

   public void setParentProject(Project parentProject) {
      this.parentProject = parentProject;
   }

   public List<Project> getSubProjets() {
      return subProjets;
   }

   public void setSubProjets(List<Project> subProjets) {
      this.subProjets = subProjets;
   }
}
