/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.service;

import com.product.crud.model.Category;
import java.util.List;

/**
 *
 * @author collins
 */
public interface categoryService {
    
    
        //get Product by id
    public Category findCategoryById(Long id);
    
    //get all Category
    public List<Category> findAllCategory();
    
    
    //Add an new Category
     public void saveCategory (Category product);
    
    
    
    
    //Edit or update Category by id
    public Category updateCategoryById(Long id);
    
    
    
    
    //Remove or Delete a Category by id
    public void deleteById(Long id);
    
    
}
