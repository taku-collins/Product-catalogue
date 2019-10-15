/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.Controllers;

import com.product.crud.model.Category;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.product.crud.repository.categoryRepository;

/**
 *
 * @author collins
 */
@RestController
@RequestMapping(categoryController.BASE_URL)
public class categoryController {
    
        public static final String BASE_URL = "/api/category/";
    
    private final categoryRepository categoryService;

      public categoryController (categoryRepository CustomersService) {
        this.categoryService = CustomersService;
         }
      
     @ApiOperation(value = "Get all Category")
     @GetMapping
     public List<Category> findAllCategory () {
        return categoryService.findAll();
     }
     
     
     @ApiOperation(value = "Get a Category by id")
     @GetMapping("/{id}")
     public ResponseEntity<ResponseEntity<Category>> getCategoryById(@PathVariable Long id) {
        ResponseEntity<Category>  category = categoryService.findById(id).map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
        return ResponseEntity.ok().body(category);
     }
     
     @ApiOperation(value = "add an new Category")
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public void saveCategory (@RequestBody Category product) {
         categoryService.save(product);
    }
     


    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
    return categoryService.findById(id)
    .map(record -> {
    categoryService.deleteById(id);
    return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
} 
     
     
     
     
     
    
    @ApiOperation(value = "Update a Category by Id")
    @PutMapping(value="/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(name = "id") long id,
    @RequestBody Category category){
    return categoryService.findById(id)
    .map(record -> {
    record.setName(category.getName());
    //record.setProduct(category.getProduct());
    Category updated = categoryService.save(record);
    return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
}



    
    

    
}
