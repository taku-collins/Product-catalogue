/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.crud.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id", updatable = false, nullable = false)
    private long id;
    
    @Column(name="product_name")
    private String name;
    
    
    @Column(name="product_Details")
    private String Details;
    
    
    @Column(name="product_quantity")
    private int quantity;
    
    @Column(name="product_price")
    private int price;
    
    
    private Integer category_id;
    
    
   /*@OneToMany(cascade = CascadeType.ALL)//, nullable = false ,mappedBy="product"
   @JoinTable(name = "categoryX_ids",joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
   private List<Category> category;*/
    
  //@ManyToOne
 /*
   @OneToOne(cascade = CascadeType.ALL)//, nullable = false
   @JoinColumn(name = "categoryX_id", referencedColumnName = "category_id")
   private Category category;*/
    
}
