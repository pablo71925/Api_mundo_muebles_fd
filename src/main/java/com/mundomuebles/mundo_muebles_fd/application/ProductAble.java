package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;

import java.util.List;

public interface ProductAble {
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    boolean delete (String code);
    List<ProductDTO> list();
}