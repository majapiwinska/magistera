package pl.edu.agh.backend.struct.enums;

public enum UserRole {
   ADMIN("Administrator"),
   USER("Użytkownik"),
   COORDINATOR("Koordynator");

   private String label;

   UserRole(String name) {
      this.label = name;
   }

   public String getLabel() {
      return label;
   }

}
