package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;
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
public class Credit {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "dues", nullable = false)
    private int dues;
    @Basic
    @Column(name = "fees_paid", nullable = true)
    private Integer feesPaid;
    @Basic
    @Column(name = "pending_fees", nullable = true)
    private Integer pendingFees;
    @ManyToOne
    @JoinColumn(name = "id_purchaser", referencedColumnName = "id", nullable = false)
    private Purchaser purchaser;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "code", nullable = false)
    private Product product;

    public Credit(CreditDTO creditDTO){
        BeanUtils.copyProperties(creditDTO, this);

    }

    public CreditDTO toCreditDTO()
    {
        CreditDTO creditDTO = new CreditDTO();
        BeanUtils.copyProperties( this,creditDTO);
        return creditDTO;
    }

}
