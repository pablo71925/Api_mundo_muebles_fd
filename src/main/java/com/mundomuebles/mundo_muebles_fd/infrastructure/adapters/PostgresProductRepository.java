package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.ProductAble;
import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Product;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresProductRepository")
@Repository("productPersistence")
public class PostgresProductRepository implements ProductAble {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return productRepository.save(new Product(productDTO)).toProductDTO();
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return productRepository.save(new Product(productDTO)).toProductDTO();
    }

    @Override
    public boolean delete(String code) {
        productRepository.deleteById(code);
        return true;
    }

    @Override
    public List<ProductDTO> list() {

        List<Product> products=productRepository.findAll();
        List<ProductDTO> productsDTO= new ArrayList<>();
        for(Product product:products)
        {
            productsDTO.add(product.toProductDTO());
        }
        return productsDTO;
    }
}
