package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
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
    public ProductDTO update(ProductDTO productDTO)throws AppException {
        return productPersistence.update(productDTO);
    }

    @Override
    public boolean delete(String code) throws AppException {
        return productPersistence.delete(code);
    }

    @Override
    public List<ProductDTO> list() {
        return productPersistence.list();
    }
}