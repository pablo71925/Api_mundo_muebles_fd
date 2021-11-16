package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryImpl implements CategoryAble {

    @Autowired
    @Qualifier("PostgresCategoryRepository")
    private CategoryAble categoryPersistence;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO)
    {
        return categoryPersistence.save(categoryDTO);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) { return categoryPersistence.update(categoryDTO); }

    @Override
    public boolean delete(int id) {
        return categoryPersistence.delete(id);
    }

    @Override
    public List<CategoryDTO> list() {
        return categoryPersistence.list();
    }
}
