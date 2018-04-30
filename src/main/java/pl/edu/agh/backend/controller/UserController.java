package pl.edu.agh.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.service.UserService;

import java.util.List;

@RestController
public class UserController {

   private final UserService userService;

   @Autowired
   UserController(UserService userService){
      this.userService = userService;

   }

   @RequestMapping("/users")
   public List<UserDto> users() {
      return userService.getAllUsers();
   }
}
