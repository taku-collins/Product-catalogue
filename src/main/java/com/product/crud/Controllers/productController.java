/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.Controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.product.crud.model.Product;
import com.product.crud.repository.productRepository;
import com.product.crud.service.productServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author collins
 */
@RestController
@RequestMapping(productController.BASE_URL)
public class productController {
    
    public static final String BASE_URL = "/api/products/";
    
    private final productRepository productService;
    
    private final productServiceImpl productServiceImp;

    public productController (productRepository productService, productServiceImpl productServiceImp) {
        this.productService = productService;
        this.productServiceImp = productServiceImp;
    }

  
    
    @ApiResponses(value = {

    @ApiResponse(code = 200, message = "Successfully retrieved list"),

    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),

    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),

    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")

})
    
    
    

   @ApiOperation(value = "Get all product in a  list")
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.findAll();
    }
    
    
    @ApiOperation(value = "Get an Product by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntity<Product>> getProductById(@PathVariable Long id){
        ResponseEntity<Product>  product = productService.findById(id).map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build()); 
        return ResponseEntity.ok().body(product);
   
    }
    
    
    
    
    
    @ApiOperation(value = "Update a Product by Id")
    @PutMapping(value="/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id,
    @RequestBody Product product){
    return productService.findById(id)
    .map(recordProduct -> {
    recordProduct.setName(product.getName());
    recordProduct.setPrice(product.getPrice());
    recordProduct.setQuantity(product.getQuantity());
    recordProduct.setDetails(product.getDetails());
    Product updated = productService.save(recordProduct);
    return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
    }
    
    @ApiOperation(value = "Delete a Product by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
    productService.findById(id).map(record -> ResponseEntity.ok().body(record))
    .orElse(ResponseEntity.notFound().build());
    productService.deleteById(id);
    return null;
      
    }
    
    
    @CrossOrigin
    @PostMapping(value = "/{id}/category/{categoryId}")
    @ApiOperation(value = "Create a relation between category and product")
    @ApiResponses(value = {
    @ApiResponse(code = 404, message = "ID of product or category invalid")
    })
   
    public ResponseEntity<?> saveProduct(@ApiParam(value = "ID of user", required = true)
             @PathVariable("categoryId") Long categoryId,
             @ApiParam(value = "ID of project", required = true)
             @PathVariable("id") Long productId) {
            
            productServiceImp.saveProduct(categoryId, productId); 
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}/categorys/{categoryId}")
            .buildAndExpand(productId, categoryId).toUri();
            return ResponseEntity.created(location).build();
    }
    
    
 /*   @CrossOrigin
    @PostMapping(value = "/add")
    @ApiOperation(value = "Add a new product")
    public Map<String, Object> createProject(@ApiParam(value = "Product object to return", required = true)
                                                @RequestBody @Valid Product product) {
    	
    	Map<String, Object> responseData = null;
    	
        try {//saveProduct(product);
            Product createProduct = productService.saveProduct(product);
            responseData = Collections.synchronizedMap(new HashMap<>());
            responseData.put("product", createProduct);
        } catch (Exception e) {
            System.out.println(e);
        }

        return responseData;
    }*/
      
}
