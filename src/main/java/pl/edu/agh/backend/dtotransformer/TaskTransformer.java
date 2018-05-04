package pl.edu.agh.backend.dtotransformer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.backend.dto.TaskDto;
import pl.edu.agh.backend.struct.Task;

@Service
public class TaskTransformer{

   @Autowired
   ModelMapper modelMapper;

   public Task transformFromDto(Task entity, TaskDto dto){
    entity = modelMapper.map(dto, Task.class);
    return entity;
   }

   public TaskDto transformToDto(Task entity, TaskDto dto) {
      dto = modelMapper.map(entity, TaskDto.class);
      return dto;
   }
}
