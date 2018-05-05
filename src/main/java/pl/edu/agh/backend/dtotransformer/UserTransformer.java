package pl.edu.agh.backend.dtotransformer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.struct.User;

@Service
public class UserTransformer {

   private final ModelMapper modelMapper;

   @Autowired
   public UserTransformer(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
   }

   public User tranformFromDto(UserDto dto) {
      User entity = modelMapper.map(dto, User.class);
      return entity;
   }

   public UserDto transformToDto(User entity) {
      UserDto dto = modelMapper.map(entity, UserDto.class);
      return dto;
   }

}
