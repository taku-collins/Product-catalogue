/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.Bootstraping;

import com.product.crud.model.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.product.crud.model.Product;
import com.product.crud.repository.productRepository;
import java.util.List;
import com.product.crud.repository.categoryRepository;

/**
 *
 * @author collins
 */
@Component
public class DBData implements CommandLineRunner{

    private final productRepository productRepository;
    
    private final categoryRepository categoryRepository;
    
    /*public DBData (productRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public DBData (categoryRepository ategoryRepository) {
        this.categoryRepository = ategoryRepository;
    }*/
    

   public DBData (productRepository customerRepository, categoryRepository categoryRepository) {
        this.productRepository = customerRepository;
        this.categoryRepository = categoryRepository;
    }
    
    
    
    @Override
    public void run (String... args) throws Exception {
        
    
     System.out.println("Loading Customers Data");
     
     Product c1 = new Product();
     c1.setName("USB");
     c1.setQuantity(51);
     c1.setPrice(2500);
     
     c1.setDetails("Saandpit");
     productRepository.save(c1);
     
     Product c2 = new Product();
     c2.setName("Iphone x");
     c2.setQuantity(7);
     c1.setPrice(3500);
     
     c2.setDetails("TKC");
     productRepository.save(c2);
     
     Product c3 = new Product();
     c3.setName("Samsung fold");
     c3.setQuantity(14);
     c1.setPrice(800000);
     
     c3.setDetails("Latest");
     productRepository.save(c3);
     
     
     
     ///Category
     
     
          
     Category t1 = new Category();
     
     t1.setId(1);
     t1.setName("Phone");
     categoryRepository.save(t1);
    
     Category t2 = new Category();
     t2.setId(2);
     t2.setName("Phone");
     //t2.setProduct(c3);
     categoryRepository.save(t2);
     
     Category t3 = new Category();
     t3.setId(3);
     t3.setName("Phone");
     //t3.setProduct(c3);
     categoryRepository.save(t3);
    
     
 
    
    
    
    
    System.out.println("Customers Saves" + productRepository);
    
    //System.out.println("ategory Saves" +categoryRepository.count());
    
    }
    
    
    
}
