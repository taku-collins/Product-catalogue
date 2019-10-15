/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author collins
 */
@Data
@Entity
@Table(name="category")
public class Category {
    
    @ApiModelProperty(notes = "The database generated category ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id" ,updatable = false)
    private long id;
    
    @ApiModelProperty(notes = "The name of category")
    @Column(name="category_name", length=50)
    private String name;
    
   
    
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private List<Product> product;
    
    
    
    
    
   //@ManyToOne
   //@JoinColumn(name = "productx")
   //private Product product;

   
   
   /* @OneToOne(mappedBy = "category")
   private Product product;*/


  /* public Category (long id, String name) {
        
        this.id = id;
        this.name = name;
    }
*/
   








    
    
}
