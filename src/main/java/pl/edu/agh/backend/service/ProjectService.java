package pl.edu.agh.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.dtotransformer.ProjectTransformer;
import pl.edu.agh.backend.repository.ProjectRepository;
import pl.edu.agh.backend.repository.UserRepository;
import pl.edu.agh.backend.struct.Project;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectService {

   private ProjectTransformer projectTransformer = new ProjectTransformer();
   private final ProjectRepository projectRepository;
   private final UserRepository userRepository;

   @Autowired
   public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
      this.projectRepository = projectRepository;
      this.userRepository = userRepository;
   }

   public List<ProjectDto> getAllProjects() {
      List<Project> projects = projectRepository.findAll();
      ProjectDto dto = new ProjectDto();
      List<ProjectDto> projectDtos = new LinkedList<>();
      projects.forEach(project -> {
         projectDtos.add(projectTransformer.transformToDto(project));
      });
      return projectDtos;
   }

   public ProjectDto save(ProjectDto projectDto) {
      Project project = projectTransformer.transformFromDto(projectDto);
      project.setOwner(userRepository.findById(projectDto.getOwner().getId()).get());
      project = projectTransformer.transformFromDto(projectDto);
      project = projectRepository.save(project);
      return projectTransformer.transformToDto(project);
   }

}
