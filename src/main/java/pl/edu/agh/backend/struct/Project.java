package pl.edu.agh.backend.struct;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
   private List<Subproject> subprojects = new LinkedList<>();

   public Project() {
   }

   public Project(String name, String description, User owner) {
      this.name = name;
      this.description = description;
      this.owner = owner;
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

   public List<Subproject> getSubprojects() {
      return subprojects;
   }

   public void setSubprojects(List<Subproject> subprojects) {
      this.subprojects = subprojects;
   }


}
