package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Purchaser {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
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
    private int phone;
    @Basic
    @Column(name = "date_purchase", nullable = false)
    private LocalDate datePurchase;
    @ManyToOne
    @JoinColumn(name = "purchased_product", referencedColumnName = "code", nullable = false)
    private Product product;

}
