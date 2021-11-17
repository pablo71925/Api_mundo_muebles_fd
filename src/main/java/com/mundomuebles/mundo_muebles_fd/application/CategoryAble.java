package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;

import java.util.List;

public interface CategoryAble {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO)throws AppException;
    boolean delete (int id) throws AppException;
    List<CategoryDTO> list();
}
