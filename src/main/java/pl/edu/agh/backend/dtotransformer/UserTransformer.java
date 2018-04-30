package pl.edu.agh.backend.dtotransformer;

import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.struct.User;

@Service
public class UserTransformer {

   public User tranformFromDto(UserDto dto, User entity) {
      if(dto.getId() != null) {
         entity.setId(dto.getId());
      }
      entity.setFirstName(dto.getFirstName());
      entity.setLastName(dto.getLastName());
      entity.setNick(dto.getNick());
      entity.setEmail(dto.getEmail());
      entity.setRole(dto.getRole());
      return entity;
   }

   public UserDto transformToDto(User entity, UserDto dto){
      dto.setId(entity.getId());
      dto.setFirstName(entity.getFirstName());
      dto.setLastName(entity.getLastName());
      dto.setNick(entity.getNick());
      dto.setEmail(entity.getEmail());
      dto.setRole(entity.getRole());
      return dto;
   }

}
