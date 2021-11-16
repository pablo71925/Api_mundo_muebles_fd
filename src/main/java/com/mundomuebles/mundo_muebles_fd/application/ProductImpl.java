package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductImpl implements ProductAble {

    @Autowired
    @Qualifier("PostgresProductRepository")
    private ProductAble productPersistence;

    @Override
    public ProductDTO save(ProductDTO productDTO)
    {
        return productPersistence.save(productDTO);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return productPersistence.update(productDTO);
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<ProductDTO> list() {
        return productPersistence.list();
    }
}