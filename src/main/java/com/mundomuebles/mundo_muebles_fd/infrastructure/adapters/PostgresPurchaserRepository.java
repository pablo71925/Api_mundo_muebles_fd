package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.PurchaserAble;
import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;
import com.mundomuebles.mundo_muebles_fd.exception.AppException;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Purchaser;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.PurchaserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresPurchaserRepository")
@Repository("purchaserPersistence")
public class PostgresPurchaserRepository implements PurchaserAble {

    @Autowired
    private PurchaserRepository purchaserRepository;

    @Override
    public PurchaserDTO save(PurchaserDTO purchaserDTO) {
        return purchaserRepository.save(new Purchaser(purchaserDTO)).toPurchaserDTO();
    }

    @Override
    public PurchaserDTO update(PurchaserDTO purchaserDTO)throws AppException{
        if (purchaserRepository.existsById(purchaserDTO.getId())){
            try{
                return
                        purchaserRepository.save(new Purchaser(purchaserDTO)).toPurchaserDTO();

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
    public boolean delete(BigInteger id) throws AppException {
        if (purchaserRepository.existsById(id)){
            try{
                purchaserRepository.deleteById(id);
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
    public List<PurchaserDTO> list() {

        List<Purchaser> purchasers=purchaserRepository.findAll();
        List<PurchaserDTO> purchasersDTO= new ArrayList<>();
        for(Purchaser purchaser:purchasers)
        {
            purchasersDTO.add(purchaser.toPurchaserDTO());
        }
        return purchasersDTO;
    }
}
