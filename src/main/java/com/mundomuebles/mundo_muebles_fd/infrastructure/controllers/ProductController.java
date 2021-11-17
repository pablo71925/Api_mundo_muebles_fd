package com.mundomuebles.mundo_muebles_fd.infrastructure.controllers;

import com.mundomuebles.mundo_muebles_fd.application.ProductImpl;
import com.mundomuebles.mundo_muebles_fd.domain.ProductDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
import com.mundomuebles.mundo_muebles_fd.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    private ProductImpl productImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid ProductDTO productDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                productImpl.save(productDTO), null),  HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid ProductDTO productDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                productImpl.save(productDTO), null),  HttpStatus.OK);
    }

    @DeleteMapping("{code}")
    public @ResponseBody
    ResponseEntity<ResponseDTO> delete(@PathVariable String code) throws AppException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                productImpl.delete(code), null),  HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                productImpl.list(), null),  HttpStatus.OK);
    }
}