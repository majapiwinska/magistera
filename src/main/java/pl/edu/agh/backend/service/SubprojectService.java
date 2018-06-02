package pl.edu.agh.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.dto.SubprojectDto;
import pl.edu.agh.backend.dtotransformer.SubprojectTransformer;
import pl.edu.agh.backend.repository.ProjectRepository;
import pl.edu.agh.backend.repository.SubprojectRepository;
import pl.edu.agh.backend.struct.Project;
import pl.edu.agh.backend.struct.Subproject;

@Service
public class SubprojectService {

   private final SubprojectRepository subprojectRepository;
   private final ProjectRepository projectRepository;
   private SubprojectTransformer subprojectTransformer = new SubprojectTransformer();

   @Autowired
   public SubprojectService(SubprojectRepository subprojectRepository, ProjectRepository projectRepository) {
      this.subprojectRepository = subprojectRepository;
      this.projectRepository = projectRepository;
   }

   public SubprojectDto save(SubprojectDto subprojectDto) {
      Subproject subproject = subprojectTransformer.transformFromDto(subprojectDto);
      subproject.setProject(projectRepository.findById(subprojectDto.getProjectId()).get());
      subproject = subprojectRepository.save(subprojectTransformer.transformFromDto(subprojectDto));
      return subprojectTransformer.transformToDto(subproject);

   }

}
