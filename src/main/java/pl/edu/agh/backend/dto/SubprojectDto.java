package pl.edu.agh.backend.dto;

public class SubprojectDto {

   private Long id;
   private String name;
   private Long projectId;

   public SubprojectDto() {
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

   public Long getProjectId() {
      return projectId;
   }

   public void setProjectId(Long projectId) {
      this.projectId = projectId;
   }
}
