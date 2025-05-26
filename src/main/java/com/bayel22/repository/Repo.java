package com.bayel22.repository;

import com.bayel22.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends PagingAndSortingRepository<Product, Long> {


}
