package pl.edu.agh.backend.service;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.dtotransformer.UserTransformer;
import pl.edu.agh.backend.repository.UserRepository;
import pl.edu.agh.backend.struct.User;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

   private final UserRepository userRepository;
   private final UserTransformer userTransformer;

   @Autowired
   UserService(UserRepository userRepository, UserTransformer userTransformer){
      this.userRepository = userRepository;
      this.userTransformer = userTransformer;
   };


   public List<UserDto> getAllUsers(){
      UserDto dto = new UserDto();
      List<UserDto> userDtoList = new LinkedList<>();
      userRepository.findAll().forEach(entity -> userDtoList.add(userTransformer.transformToDto(entity, dto)));
      System.out.println(userRepository.findAll().toString());
      return userDtoList;
   }
}
