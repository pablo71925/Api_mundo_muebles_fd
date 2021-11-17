package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.ProductAble;
import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
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
    public ProductDTO update(ProductDTO productDTO)throws AppException{
        if (productRepository.existsById(productDTO.getCode())){
            try{
                return
                        productRepository.save(new Product(productDTO)).toProductDTO();

            }
            catch(Exception e) {
                throw new AppException("No se puede actualizar el registro");
            }


        }
        else {
            throw new AppException("El registro no existe");

        }
    }

    @Override
    public boolean delete(String code) throws AppException {
        if (productRepository.existsById(code)){
            try{
                productRepository.deleteById(code);
                return true;
            }
            catch(Exception e) {
                throw new AppException("El registro no se puede eliminar");
            }

        }
        else {
            throw new AppException("El registro a eliminar no existe");

        }
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
