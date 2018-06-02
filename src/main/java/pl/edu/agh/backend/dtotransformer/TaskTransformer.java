package pl.edu.agh.backend.dtotransformer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.struct.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskTransformer {
   public TaskTransformer() {
   }

   public Task transformFromDto(TaskDto dto) {
     Task entity = new Task();
     if(dto.getId() != null){
        entity.setId(dto.getId());
     }
     entity.setName(dto.getName());
     entity.setDescription(dto.getDescription());
     entity.setStartDate(dto.getStartDate());
     entity.setEndDate(dto.getEndDate());
     entity.setStatus(dto.getStatus());
     entity.setEstimatedTime(dto.getEstimatedTime());
     entity.setProgress(dto.getProgress());
     entity.setUsedTime(dto.getUsedTime());
      return entity;
   }

   public TaskDto transformToDto(Task entity) {
      return null;
   }
}
