package pl.edu.agh.backend.dtotransformer;

public interface AbstractTransformer<E, T> {

   E transformFromDto(E e, T t);

   T transformToDto(E e, T t);
}
