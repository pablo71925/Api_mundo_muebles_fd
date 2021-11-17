package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


@Service
public class PurchaserImpl implements PurchaserAble {

    @Autowired
    @Qualifier("PostgresPurchaserRepository")
    private PurchaserAble purchaserPersistence;

    @Override
    public PurchaserDTO save(PurchaserDTO purchaserDTO)
    {
        return purchaserPersistence.save(purchaserDTO);
    }

    @Override
    public PurchaserDTO update(PurchaserDTO purchaserDTO)throws AppException {
        return purchaserPersistence.update(purchaserDTO);
    }

    @Override
    public boolean delete(BigInteger id) throws AppException {
        return purchaserPersistence.delete(id);
    }

    @Override
    public List<PurchaserDTO> list() {
        return purchaserPersistence.list();
    }
}
