package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;

import java.math.BigInteger;
import java.util.List;

public interface PurchaserAble {
    PurchaserDTO save(PurchaserDTO purchaserDTO);
    PurchaserDTO update(PurchaserDTO purchaserDTO)throws AppException;
    boolean delete (BigInteger id) throws AppException;
    List<PurchaserDTO> list();
}
