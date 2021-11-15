package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;

import java.util.List;

public interface CreditAble {
    CreditDTO save(CreditDTO creditDTO);
    CreditDTO update(CreditDTO creditDTO);
    boolean delete (int id);
    List<CreditDTO> list();
}
