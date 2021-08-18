package kg.project.apartment_rental_system.service.base;

import java.util.List;

public interface BaseService<S, T> {

    S save(S s);
    S update(S s);
    void removeByID(T id);
    S findById(T id);
    List<S> findAll();
}
