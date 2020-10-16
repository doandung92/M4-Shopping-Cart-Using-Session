package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IService<E> {
    Iterable<E> findAll();
    E findById(Long id);
    E save(E e);
    E remove(Long id);
}
