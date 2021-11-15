package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Purchaser {
    @Id
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "direction", nullable = false, length = 50)
    private String direction;
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;
    @Basic
    @Column(name = "date_purchase", nullable = false)
    private LocalDate datePurchase;
    @ManyToOne
    @JoinColumn(name = "purchased_product", referencedColumnName = "code", nullable = false)
    private Product product;

    public Purchaser(PurchaserDTO purchaserDTO){
        BeanUtils.copyProperties(purchaserDTO, this);
    }

    public PurchaserDTO toPurchaserDTO()
    {
        PurchaserDTO purchaserDTO = new PurchaserDTO();
        BeanUtils.copyProperties( this,purchaserDTO);
        return purchaserDTO;
    }
}
