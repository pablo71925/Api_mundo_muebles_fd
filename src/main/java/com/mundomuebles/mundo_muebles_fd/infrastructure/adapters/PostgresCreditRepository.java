package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.CreditAble;
import com.mundomuebles.mundo_muebles_fd.domain.CreditDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
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
    public CreditDTO update(CreditDTO creditDTO)throws AppException{
        if (creditRepository.existsById(creditDTO.getId())){
            try{
                return
                        creditRepository.save(new Credit(creditDTO)).toCreditDTO();

            }
            catch(Exception e) {
                throw new AppException("No se puede actualizar el registro");
            }


        }
        else {
            throw new AppException("El registro no existe");

        }
    }

    @Override
    public boolean delete(int id) throws AppException {
        if (creditRepository.existsById(id)){
            try{
                creditRepository.deleteById(id);
                return true;
            }
            catch(Exception e) {
                throw new AppException("El registro no se puede eliminar");
            }
        }
        else {
            throw new AppException("El registro a eliminar no existe");

        }
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
