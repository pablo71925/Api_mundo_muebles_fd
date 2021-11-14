package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.CategoryAble;
import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Category;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresCategoryRepository")
@Repository("categoryPersistence")
public class PostgresCategoryRepository implements CategoryAble {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
         return categoryRepository.save(new Category(categoryDTO)).toCategoryDTO();
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return categoryRepository.save(new Category(categoryDTO)).toCategoryDTO();
    }

    @Override
    public boolean delete(Integer id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CategoryDTO> list() {

        List<Category> categories=categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO= new ArrayList<>();
        for(Category category:categories)
        {
            categoriesDTO.add(category.toCategoryDTO());
        }
        return categoriesDTO;
    }
}
