package com.mundomuebles.mundo_muebles_fd.infrastructure.controllers;

import com.mundomuebles.mundo_muebles_fd.application.CreditImpl;
import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;
import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
import com.mundomuebles.mundo_muebles_fd.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "credit")
public class CreditController {

    @Autowired
    private CreditImpl creditImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CreditDTO creditDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                creditImpl.save(creditDTO), null),  HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid CreditDTO creditDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                creditImpl.save(creditDTO), null),  HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public @ResponseBody
    ResponseEntity<ResponseDTO> delete(@PathVariable int id) throws AppException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                creditImpl.delete(id), null),  HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                creditImpl.list(), null),  HttpStatus.OK);
    }
}
