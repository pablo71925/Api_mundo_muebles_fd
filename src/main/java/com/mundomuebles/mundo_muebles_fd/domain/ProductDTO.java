package com.mundomuebles.mundo_muebles_fd.domain;

import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    @Positive
    private int price;
    @NotNull
    private Category category;
}
