package cl.praxis.proyectohospitalpost.service;

import cl.praxis.proyectohospitalpost.entity.Diagnosis;

import java.util.List;

public interface IBasedCRUD<T> {
    List<T> getAll();
    T getById(Long id);
   T insert(T t);
   T update(T t);

    void delete(Long id);

}
