package com.bank.app_bank.repository;

import java.util.List;
import java.util.Optional;

public interface JsonRepository<T>{
    List<T> findAll(); //leer
    Optional<T> findById(String id); //leer por id
    void save(T entity); // crear
    void update(T entity); // actualizar
    void delete(String Id); //eliminar
}
