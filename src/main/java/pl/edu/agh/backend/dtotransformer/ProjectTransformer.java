package pl.edu.agh.backend.dtotransformer;

import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.struct.Project;

public class ProjectTransformer {

   private UserTransformer userTransformer = new UserTransformer();

   public Project transformFromDto(ProjectDto dto) {
      Project entity = new Project();
      if (dto.getId() != null) {
         entity.setId(dto.getId());
      }
      entity.setName(dto.getName());
      entity.setDescription(dto.getDescription());
      entity.setOwner(userTransformer.tranformFromDto(dto.getOwner()));
      return entity;
   }

   public ProjectDto transformToDto(Project entity) {
      ProjectDto dto = new ProjectDto();
      dto.setId(entity.getId());
      dto.setName(entity.getName());
      dto.setDescription(entity.getDescription());
      dto.setOwner(userTransformer.transformToDto(entity.getOwner()));
      return dto;
   }
}
