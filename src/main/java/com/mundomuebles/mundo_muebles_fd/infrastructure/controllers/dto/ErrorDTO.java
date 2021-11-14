package com.mundomuebles.mundo_muebles_fd.infrastructure.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private int code;
    private String message;
}
