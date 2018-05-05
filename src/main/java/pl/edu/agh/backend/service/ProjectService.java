package pl.edu.agh.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.dtotransformer.ProjectTransformer;
import pl.edu.agh.backend.repository.ProjectRepository;
import pl.edu.agh.backend.struct.Project;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectService {

   private final ProjectTransformer projectTransformer;
   private final ProjectRepository projectRepository;

   @Autowired
   public  ProjectService(ProjectTransformer projectTransformer,ProjectRepository projectRepository ){
      this.projectRepository = projectRepository;
      this.projectTransformer = projectTransformer;
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

   public ProjectDto save(ProjectDto projectDto){
      Project project = new Project();
      project = projectRepository.save(projectTransformer.transformFromDto(projectDto));
      return projectTransformer.transformToDto(project);
   }

}
