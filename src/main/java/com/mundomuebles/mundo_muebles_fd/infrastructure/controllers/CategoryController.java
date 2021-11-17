package com.mundomuebles.mundo_muebles_fd.infrastructure.controllers;

import com.mundomuebles.mundo_muebles_fd.application.CategoryImpl;
import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
import com.mundomuebles.mundo_muebles_fd.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "category")
public class CategoryController {

    @Autowired
    private CategoryImpl categoryImpl;



    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CategoryDTO categoryDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                categoryImpl.save(categoryDTO), null),  HttpStatus.OK);
    }


    @PutMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid CategoryDTO categoryDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                categoryImpl.save(categoryDTO), null),  HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public @ResponseBody
    ResponseEntity<ResponseDTO> delete(@PathVariable int id) throws AppException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                categoryImpl.delete(id), null),  HttpStatus.OK);
    }


    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                categoryImpl.list(), null),  HttpStatus.OK);
    }
}
