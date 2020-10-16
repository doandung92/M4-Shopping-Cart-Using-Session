package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends IService<Product> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
