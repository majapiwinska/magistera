package pl.edu.agh.backend.struct;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserGroup implements Serializable {

   private static final long serialVersionUID = -4707650434864841921L;

   @Id
   private Integer id;
   private String name;


}
