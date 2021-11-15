package com.mundomuebles.mundo_muebles_fd.infrastructure.adapters;

import com.mundomuebles.mundo_muebles_fd.application.PurchaserAble;
import com.mundomuebles.mundo_muebles_fd.domain.PurchaserDTO;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.Purchaser;
import com.mundomuebles.mundo_muebles_fd.infrastructure.repositories.PurchaserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
    public PurchaserDTO update(PurchaserDTO purchaserDTO) {
        return purchaserRepository.save(new Purchaser(purchaserDTO)).toPurchaserDTO();
    }

    @Override
    public boolean delete(Integer id) {
        purchaserRepository.deleteById(id);
        return true;
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
