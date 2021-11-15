package com.mundomuebles.mundo_muebles_fd.domain;

import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Product;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Purchaser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {

    @NotNull
    private int id;
    @PositiveOrZero
    private int dues;
    @PositiveOrZero
    private Integer feesPaid;
    @PositiveOrZero
    private Integer pendingFees;
    @NotNull
    private Purchaser purchaser;
    @NotNull
    private Product product;
}
