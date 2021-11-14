package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    @Id
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private Category category;

    public Product(ProductDTO productDTO){
        BeanUtils.copyProperties(productDTO, this);
    }

    public ProductDTO toProductDTO()
    {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties( this,productDTO);
        return productDTO;
    }
    
}
