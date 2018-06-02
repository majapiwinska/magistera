package pl.edu.agh.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.backend.dto.UserDto;
import pl.edu.agh.backend.service.UserService;
import pl.edu.agh.backend.struct.LoginUser;
import pl.edu.agh.backend.struct.User;

import java.util.List;

@RestController
public class UserController {

   public static final Logger logger = LoggerFactory.getLogger(UserController.class);

   private final UserService userService;

   @Autowired
   UserController(UserService userService) {
      this.userService = userService;

   }

   @RequestMapping("/users")
   public List<UserDto> users() {
      return userService.getAllUsers();
   }

   @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
   public UserDto user(@PathVariable String username) {

      return userService.findByUsername(username);
   }

   @RequestMapping(value = "/signup", method = RequestMethod.POST)
   public UserDto saveUser(@RequestBody UserDto user) {
      return userService.save(user);

   }

   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public UserDto login(@RequestBody LoginUser loginUser) {
     return userService.login(loginUser);
   }

}
