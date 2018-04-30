package pl.edu.agh.backend.struct;

import pl.edu.agh.backend.struct.enums.UserRole;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

   private static final long serialVersionUID = -8706487736618634306L;

   @Id
   private Integer id;
   private String firstName;
   private String lastName;
   private String nick;
   private String email;
   private UserRole role;

   public User() {
   }

   public User(String firstName, String lastName, String nick, String email, UserRole role) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.nick = nick;
      this.email = email;
      this.role = role;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getNick() {
      return nick;
   }

   public void setNick(String nick) {
      this.nick = nick;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public UserRole getRole() {
      return role;
   }

   public void setRole(UserRole role) {
      this.role = role;
   }
}
