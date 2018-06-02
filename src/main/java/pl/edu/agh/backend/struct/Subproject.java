package pl.edu.agh.backend.struct;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Subproject implements Serializable {

   private static final long serialVersionUID = 7113891984115655209L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;

   @ManyToOne
   @JoinColumn(name = "project_id")
   private Project project;

   @OneToMany(mappedBy = "subproject", cascade = CascadeType.ALL)
   private List<Task> tasks = new LinkedList<>();

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

   public Project getProject() {
      return project;
   }

   public void setProject(Project project) {
      this.project = project;
   }

   public List<Task> getTasks() {
      return tasks;
   }

   public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
   }
}
