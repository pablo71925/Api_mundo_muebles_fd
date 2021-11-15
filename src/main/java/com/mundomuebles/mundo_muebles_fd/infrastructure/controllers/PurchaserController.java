package com.mundomuebles.mundo_muebles_fd.infrastructure.controllers;

import com.mundomuebles.mundo_muebles_fd.application.PurchaserImpl;
import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;
import com.mundomuebles.mundo_muebles_fd.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "purchaser")
public class PurchaserController {

    @Autowired
    private PurchaserImpl purchaserImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid PurchaserDTO purchaserDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                purchaserImpl.save(purchaserDTO), null),  HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                purchaserImpl.list(), null),  HttpStatus.OK);
    }
}