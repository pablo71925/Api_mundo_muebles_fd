package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.CreditAble;
import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Credit;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresCreditRepository")
@Repository("creditPersistence")
public class PostgresCreditRepository implements CreditAble {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public CreditDTO save(CreditDTO creditDTO) {
        return creditRepository.save(new Credit(creditDTO)).toCreditDTO();
    }

    @Override
    public CreditDTO update(CreditDTO creditDTO) {
        return creditRepository.save(new Credit(creditDTO)).toCreditDTO();
    }

    @Override
    public boolean delete(int id) {
        creditRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CreditDTO> list() {

        List<Credit> credits=creditRepository.findAll();
        List<CreditDTO> creditsDTO= new ArrayList<>();
        for(Credit credit:credits)
        {
            creditsDTO.add(credit.toCreditDTO());
        }
        return creditsDTO;
    }
}
