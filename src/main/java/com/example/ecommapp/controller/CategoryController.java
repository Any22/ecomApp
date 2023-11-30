package com.example.ecommapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommapp.categoriesDTO.CategoryDTO;
import com.example.ecommapp.exception.NotFoundException;
import com.example.ecommapp.service.CategoryService;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired 
	CategoryService categoryService;
	
	/**************************************************************************************************************
	 * ResponseEntity adds header and HTTP Status code to the response 
	 * @return
	 * @throws NotFoundException
	 */
	 @GetMapping(value="/categories")
	    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws NotFoundException{
		 List<CategoryDTO> categoriesDTO = categoryService.getAllCategoriesDTO();
		 
		 if (categoriesDTO.isEmpty()) {
			 
			 throw new NotFoundException("no product categories found");
		 }
	        return new ResponseEntity<List<CategoryDTO>>(categoriesDTO,HttpStatus.OK);
	    }
	 
	 @GetMapping(value="/categories/{categoryId}")
	 
	    public ResponseEntity<CategoryDTO> getCategoryById (@PathVariable Integer categoryId) throws NotFoundException {
		 CategoryDTO categoriesDTO = categoryService.getCategory(categoryId);
		 
		 try {
			
			 if (null == categoriesDTO ) {
				 
				 throw new NotFoundException("no such category found");
			 }
		        
		        
		    } catch(Exception e) {
			 e.getMessage();
		 }
		 return new ResponseEntity (categoriesDTO.getCategoryName(),HttpStatus.OK);
		 
	 }
	 
	
	 
}
