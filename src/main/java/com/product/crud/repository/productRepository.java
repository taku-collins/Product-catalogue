/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.product.crud.model.Product;

/**
 *
 * @author collins
 */
    public interface productRepository extends JpaRepository<Product, Long> {

    
    
}
