package pl.edu.agh.backend.dto;

import pl.edu.agh.backend.struct.enums.TaskStatus;

import java.time.ZonedDateTime;
import java.util.List;

public class TaskDto {

   private Long id;
   private String name;
   private String description;
   private ZonedDateTime startDate;
   private ZonedDateTime endDate;
   private TaskStatus status;
   private int estimatedTime;
   private int progress;
   private int usedTime;

   private Long userId;

   private Long subprojectId;

   public TaskDto() {
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

   public int getUsedTime() {
      return usedTime;
   }

   public void setUsedTime(int usedTime) {
      this.usedTime = usedTime;
   }

   public Long getUserId() {
      return userId;
   }

   public void setUserId(Long userId) {
      this.userId = userId;
   }

   public Long getSubprojectId() {
      return subprojectId;
   }

   public void setSubprojectId(Long subprojectId) {
      this.subprojectId = subprojectId;
   }
}
