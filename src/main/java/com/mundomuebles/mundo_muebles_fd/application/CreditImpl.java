package com.mundomuebles.mundo_muebles_fd.application;

import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreditImpl implements CreditAble {

    @Autowired
    @Qualifier("PostgresCreditRepository")
    private CreditAble creditPersistence;

    @Override
    public CreditDTO save(CreditDTO creditDTO)
    {
        return creditPersistence.save(creditDTO);
    }

    @Override
    public CreditDTO update(CreditDTO creditDTO) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<CreditDTO> list() {
        return creditPersistence.list();
    }
}

