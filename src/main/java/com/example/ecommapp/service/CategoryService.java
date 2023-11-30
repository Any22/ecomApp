package com.example.ecommapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommapp.categoriesDTO.CategoryDTO;
import com.example.ecommapp.exception.NotFoundException;
import com.example.ecommapp.model.Category;
import com.example.ecommapp.repository.CategoryRepository;

@Service
public class CategoryService {
	 @Autowired 
	 private CategoryRepository categoryRepository;
	 
	 
	 /*********************************************************************************************************************
	  * Returning all categories stored in the database .Validations yet to be implemented
	  * @return		List of CategoryDTO objects 
	  * 
	  *********************************************************************************************************************/
	public List<CategoryDTO> getAllCategoriesDTO() {
		
	  	List<Category> categories =  categoryRepository.findAll();
	  	
    	//Creating an empty array to store all DTOs
               List<CategoryDTO> categoryDTOs = new ArrayList<>();
        
        //iterate over each category to convert it into DTO
               
              for (Category cat: categories) {
                  categoryDTOs.add(CategoryDTO.toDTO(cat));
             }
        return categoryDTOs;
    }
	
	/***********************************************************************************************************************
	 * Search the database for a specific category and return all its details .
	 * 
	 * @param categoryId     the id of the category 
	 * @return               A DTO object corresponding to the category entity object found in database
	 * @throws NotFoundException 
	 
	 ************************************************************************************************************************/
	
	
	public CategoryDTO getCategory (Integer categoryId) throws NotFoundException {
		
		/********************************************************************************************************************
		 * Either you get a category by its id or their will be no category for a particular id 
		 * we will handle this using Optional class provided by java util package. It's a way to handle potential null results
		 * without resorting to explicit null checks. 
		 * The methods : isPresent() or ifPresent(), to safely work with the result.
		 * 
		 ********************************************************************************************************************/
		
	Category categories =  categoryRepository.findById(categoryId)
				.orElseThrow(()-> new NotFoundException ("Product category does not exists"));
	
		return CategoryDTO.toDTO(categories);
	}
}

