package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;

import java.util.List;

public interface PurchaserAble {
    PurchaserDTO save(PurchaserDTO purchaserDTO);
    PurchaserDTO update(PurchaserDTO purchaserDTO);
    boolean delete (Integer id);
    List<PurchaserDTO> list();
}
