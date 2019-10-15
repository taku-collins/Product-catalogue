/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.service;

import com.product.crud.model.Category;
import java.util.List;
import org.springframework.stereotype.Service;
import com.product.crud.repository.categoryRepository;

/**
 *
 * @author collins
 */
@Service
public class categoryServiceImpl implements categoryService {
    private final categoryRepository categoryrepository;

    public categoryServiceImpl (categoryRepository productCategory) {
        this.categoryrepository = productCategory;
    }
    
    @Override
    public Category findCategoryById (Long id) {
        //return categoryrepository.findById(id).get();
       return categoryrepository.findById(id).get();
    }

    @Override
    public List<Category> findAllCategory () {
        return categoryrepository.findAll();
    }

    @Override
    public void saveCategory (Category product) {
        categoryrepository.save(product);
    }

    @Override
    public Category updateCategoryById (Long id) {
        return null;
        //return categoryrepository.save(id);
    }

    @Override
    public void deleteById (Long id) {
        categoryrepository.deleteById(id);
    }


    
}
