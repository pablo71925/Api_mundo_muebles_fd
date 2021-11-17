package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;

import java.util.List;

public interface CreditAble {
    CreditDTO save(CreditDTO creditDTO);
    CreditDTO update(CreditDTO creditDTO)throws AppException;
    boolean delete (int id) throws AppException;
    List<CreditDTO> list();
}
