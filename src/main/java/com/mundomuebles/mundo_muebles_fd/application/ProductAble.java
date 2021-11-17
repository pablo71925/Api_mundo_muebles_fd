package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;

import java.util.List;

public interface ProductAble {
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO)throws AppException;
    boolean delete (String code) throws AppException;
    List<ProductDTO> list();
}