package cue.edu.co.VeloceRentalsSpring.velocerentals.services.interfaces;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();
    T findById(Long id);
    void create(T entity);
    void remove(Long id);
    Boolean existsById(Long id);
}
