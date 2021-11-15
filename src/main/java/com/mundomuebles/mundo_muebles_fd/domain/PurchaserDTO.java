package com.mundomuebles.mundo_muebles_fd.domain;


import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaserDTO {
    @NotNull
    private BigInteger id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String direction;
    @NotNull
    @Size(min = 0, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;
    @NotNull
    private LocalDate datePurchase;
    @NotNull
    private Product product;

}
