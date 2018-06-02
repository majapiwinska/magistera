package pl.edu.agh.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.dtotransformer.UserTransformer;
import pl.edu.agh.backend.repository.RoleRepository;
import pl.edu.agh.backend.repository.UserRepository;
import pl.edu.agh.backend.struct.LoginUser;
import pl.edu.agh.backend.struct.User;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

   private final UserRepository userRepository;
   private UserTransformer userTransformer = new UserTransformer();

   private final RoleRepository roleRepository;

   @Autowired
   UserService(UserRepository userRepository, RoleRepository roleRepository) {
      this.userRepository = userRepository;
      this.roleRepository = roleRepository;

   }

   public UserDto findByUsername(String username) {
      UserDto dto = new UserDto();
      return userTransformer.transformToDto(userRepository.findOneByUsername(username));
   }

   public List<UserDto> getAllUsers() {
      UserDto dto = new UserDto();
      List<UserDto> userDtoList = new LinkedList<>();
      userRepository.findAll().forEach(entity -> userDtoList.add(userTransformer.transformToDto(entity)));
      System.out.println(userRepository.findAll().toString());
      return userDtoList;
   }

   public UserDto login(LoginUser loginUser) {
      User user = this.userRepository
            .findByUsernameEqualsAndPasswordEquals(loginUser.getUsername(), loginUser.getPassword());
      if (user != null) {
         return userTransformer.transformToDto(user);
      } else
         return null;
   }

   public UserDto save(UserDto dto) {
      User user = new User();
      user = userTransformer.tranformFromDto(dto);
      return userTransformer.transformToDto(this.userRepository.save(user));

   }

}