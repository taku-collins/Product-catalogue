/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.product.crud.model.Product;
import com.product.crud.repository.productRepository;
import static java.util.Objects.requireNonNull;



/**
 *
 * @author collins
 */

@Service
public class productServiceImpl implements productService{
    
    private final productRepository productRepository;
  

    public productServiceImpl (productRepository productRepository) {
        this.productRepository = productRepository;
     
    }

  

 
    
    
    
    @Override
    public Product findProductById(Long id){
         return productRepository.findById(id).get();
    
    }

    @Override
    public List<Product> findAllProduct () {
        return productRepository.findAll();
    }
    
    
    
    @Override
    
    //Integer userId, Integer projectId
    public Product saveProduct (Long categoryId, Long productId) {
        
    //Category category = categoryRepository.findById(categoryId).get();
    
    Product category = productRepository.findById(categoryId).get();
    
    Product product = productRepository.findById(productId).get();
    requireNonNull(category, "Invalid category Id");
    requireNonNull(product, "Invalid product Id");
    //isUserAppliedPresent(categoryId, productId);
    Product productToPost = new Product();
    productToPost.setName(productToPost.getName());
    productToPost.setDetails(productToPost.getDetails());
    productToPost.setQuantity(productToPost.getQuantity());
    productToPost.setPrice(productToPost.getPrice());
    //productToPost.setCategory(new Category(id,""));
    return productRepository.save(productToPost);
    }
    
    
    @Override
    public void deleteById (Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProductById (Long id) {
        productRepository.deleteById(id);
        return null ;
    }
}
