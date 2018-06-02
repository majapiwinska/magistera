package pl.edu.agh.backend.dto;

public class ProjectDto {

   private Long id;
   private String name;
   private String description;
   private UserDto owner;


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
}
