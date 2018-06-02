package pl.edu.agh.backend.dtotransformer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.ProjectDto;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.struct.Project;
import pl.edu.agh.backend.struct.Task;
import pl.edu.agh.backend.struct.User;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UserTransformer {


   public User tranformFromDto(UserDto dto) {
      User entity = new User();
      if(dto.getId() != null){
         entity.setId(dto.getId());
      }
      entity.setFirstName(dto.getFirstName());
      entity.setLastName(dto.getLastName());
      entity.setUsername(dto.getUsername());
      entity.setEmail(dto.getEmail());
      entity.setActive(dto.getActive());
      entity.setPassword(dto.getPassword());
      entity.setRoles(dto.getRoles());
      return entity;
   }

   public UserDto transformToDto(User entity) {
      UserDto dto = new UserDto();
      dto.setId(entity.getId());
      dto.setFirstName(entity.getFirstName());
      dto.setLastName(entity.getLastName());
      dto.setUsername(entity.getUsername());
      dto.setEmail(entity.getEmail());
      dto.setActive(entity.getActive());
      dto.setPassword(entity.getPassword());
      dto.setRoles(entity.getRoles());
      return dto;
   }

}
