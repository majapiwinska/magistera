package pl.edu.agh.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

   private final ProjectService projectService;

   @Autowired
   public ProjectController(ProjectService projectService){
      this.projectService = projectService;
   }

   @RequestMapping(value = "", method = RequestMethod.GET)
   public List<ProjectDto> getAllProjects(){
      return projectService.getAllProjects();
   }

   @RequestMapping(value = "/save", method = RequestMethod.POST)
   public ProjectDto saveProject(@RequestBody ProjectDto projectDto){
      return projectService.save(projectDto);
   }

}


