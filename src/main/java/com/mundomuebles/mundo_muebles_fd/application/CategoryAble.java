package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;

import java.util.List;

public interface CategoryAble {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);
    boolean delete (int id);
    List<CategoryDTO> list();
}
