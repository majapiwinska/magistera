package pl.edu.agh.backend.dtotransformer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.struct.Project;

@Service
public class ProjectTransformer {

   @Autowired
   ModelMapper modelMapper;

   public Project transformFromDto(Project entity, ProjectDto dto){
      entity = modelMapper.map(dto, Project.class);
      return entity;
   }

   public ProjectDto transformToDto(Project entity, ProjectDto dto) {
      dto = modelMapper.map(entity, ProjectDto.class);
      return dto;
   }
}
