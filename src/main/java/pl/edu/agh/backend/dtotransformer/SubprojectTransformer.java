package pl.edu.agh.backend.dtotransformer;

import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.dto.SubprojectDto;
import pl.edu.agh.backend.struct.Project;
import pl.edu.agh.backend.struct.Subproject;

import javax.management.remote.SubjectDelegationPermission;

public class SubprojectTransformer {

   public Subproject transformFromDto(SubprojectDto dto) {
      Subproject entity = new Subproject();
      if (dto.getId() != null) {
         entity.setId(dto.getId());
      }
      entity.setName(dto.getName());
      return entity;
   }

   public SubprojectDto transformToDto(Subproject entity) {
      SubprojectDto dto = new SubprojectDto();
      dto.setId(entity.getId());
      dto.setName(entity.getName());
      dto.setProjectId(entity.getProject().getId());
      return dto;
   }
}
