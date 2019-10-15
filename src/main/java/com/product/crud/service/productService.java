/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.service;

import java.util.List;
import com.product.crud.model.Product;

/**
 *
 * @author collins
 */
public interface productService {
    
    //get Product by id
    Product findProductById(Long id);
    
    //get all Products
    List<Product> findAllProduct();
    
    
    //Add an new Product
     Product saveProduct (Long categoryId, Long productId);
    
    
    
    
    //Edit or update Product by id
    Product updateProductById(Long id);
    
    
    
    
    //Remove or Delete a Customer by id
    public void deleteById(Long id);
    
    
    
    
    
}
