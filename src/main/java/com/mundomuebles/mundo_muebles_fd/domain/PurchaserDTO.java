package com.mundomuebles.mundo_muebles_fd.domain;


import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaserDTO {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String direction;
    @NotNull
    private int phone;
    @NotNull
    private LocalDate datePurchase;
    @NotNull
    private Product product;

}
