package com.bayel22.repository;

import com.bayel22.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface Repo<T> {
    T getById(Long id);

    void update(T entity);
}
