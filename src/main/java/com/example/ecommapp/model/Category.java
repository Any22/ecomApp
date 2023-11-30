package com.example.ecommapp.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	    @Id
	    /*the SEQUENCE generation type requires us to use a custom sequence in the database */
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Integer categoryId;
	    @NotNull
	    @Length
	    @Column(name = "category_name")
	    private String categoryName;
	    @Column(name = "image_path")
	    private String imgPath;
	    
	    public Category() {
	    	
	    }
	    
		public Category(Integer categoryId,String categoryName, String imgPath) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.imgPath = imgPath;
		}
		
		public Integer getCategoryId() {
			return categoryId;
		}
		
		public String getCategoryName() {
			return categoryName;
		}
		
		public String getImgPath() {
			return imgPath;
		}
		 
	}



