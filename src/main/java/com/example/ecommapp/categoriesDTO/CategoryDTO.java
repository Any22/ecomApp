package com.example.ecommapp.categoriesDTO;

import java.io.Serializable;

import com.example.ecommapp.model.Category;

public class CategoryDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String categoryName;
	private String imgPath;
	
	public CategoryDTO() {
        // Default constructor .Jackson requires a default constructor for deserialization.
    }
	
	public CategoryDTO(Integer categoryId, String categoryName, String imgPath) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imgPath = imgPath;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public void setImgPath(String imgPath) {
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

	/************************************************
	 * 
	 * method	: converting entity object into DTO  
	 * name		: toDTO
	 * @param	: category a category entity object
	 * @return	: a categoriesDTO object 
	 * 
	 * ***********************************************/
	public static CategoryDTO  toDTO (Category category) {
		
		CategoryDTO  categoryDTO = new CategoryDTO();
	
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setImgPath(category.getImgPath());


		return categoryDTO;
	}

}
