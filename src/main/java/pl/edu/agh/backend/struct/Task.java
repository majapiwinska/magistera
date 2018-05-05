package pl.edu.agh.backend.struct;

import pl.edu.agh.backend.struct.enums.TaskStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Task implements Serializable {

   private static final long serialVersionUID = -9025267147126804290L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private ZonedDateTime startDate;
   private ZonedDateTime endDate;
   private TaskStatus status;
   private int estimatedTime;
   private int progress;
   private int usedTime;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User assignedTo;

   @ManyToOne
   @JoinColumn(name = "project_id")
   private Project project;

   @ManyToOne
   private Task parentTask;

   @OneToMany(mappedBy = "parentTask")
   private List<Task> childrenTasks = new LinkedList<>();

   public Task() {
   }

   public Task(String name, String description, ZonedDateTime startDate, ZonedDateTime endDate, TaskStatus status,
         int estimatedTime, int progress, User assignedTo, Project project, Task parentTask, List<Task> childrenTasks) {
      this.name = name;
      this.description = description;
      this.startDate = startDate;
      this.endDate = endDate;
      this.status = status;
      this.estimatedTime = estimatedTime;
      this.progress = progress;
      this.assignedTo = assignedTo;
      this.project = project;
      this.parentTask = parentTask;
      this.childrenTasks = childrenTasks;
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

   public ZonedDateTime getStartDate() {
      return startDate;
   }

   public void setStartDate(ZonedDateTime startDate) {
      this.startDate = startDate;
   }

   public ZonedDateTime getEndDate() {
      return endDate;
   }

   public void setEndDate(ZonedDateTime endDate) {
      this.endDate = endDate;
   }

   public TaskStatus getStatus() {
      return status;
   }

   public void setStatus(TaskStatus status) {
      this.status = status;
   }

   public int getEstimatedTime() {
      return estimatedTime;
   }

   public void setEstimatedTime(int estimatedTime) {
      this.estimatedTime = estimatedTime;
   }

   public int getProgress() {
      return progress;
   }

   public void setProgress(int progress) {
      this.progress = progress;
   }

   public User getAssignedTo() {
      return assignedTo;
   }

   public void setAssignedTo(User assignedTo) {
      this.assignedTo = assignedTo;
   }

   public Project getProject() {
      return project;
   }

   public void setProject(Project project) {
      this.project = project;
   }

   public Task getParentTask() {
      return parentTask;
   }

   public void setParentTask(Task parentTask) {
      this.parentTask = parentTask;
   }

   public List<Task> getChildrenTasks() {
      return childrenTasks;
   }

   public void setChildrenTasks(List<Task> childrenTasks) {
      this.childrenTasks = childrenTasks;
   }

   public int getUsedTime() {
      return usedTime;
   }

   public void setUsedTime(int usedTime) {
      this.usedTime = usedTime;
   }
}
