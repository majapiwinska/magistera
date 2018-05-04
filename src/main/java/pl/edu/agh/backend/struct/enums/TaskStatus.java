package pl.edu.agh.backend.struct.enums;

public enum TaskStatus {

   NEW("Nowy"),
   PLANNED("Planowany"),
   IN_PROGRESS("W toku"),
   REJECTED("Odrzucony"),
   WAITING_FOR_INFO("Oczekiwanie na informacje"),
   CLOSED("Zamknięty");

   private String label;

   TaskStatus(String name) {
      this.label = name;
   }

   public String getLabel() {
      return label;
   }

}
