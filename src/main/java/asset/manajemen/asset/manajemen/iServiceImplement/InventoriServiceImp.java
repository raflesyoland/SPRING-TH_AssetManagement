/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iServiceImplement;

import asset.manajemen.asset.manajemen.iRepository.InventoriIRepository;
import asset.manajemen.asset.manajemen.iService.InventoriIService;
import asset.manajemen.asset.manajemen.model.Inventori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RRAAAA
 */
@Service
public class InventoriServiceImp implements InventoriIService {
    
    @Autowired
    private InventoriIRepository inventoriIRepository;

    @Override
    public Iterable<Inventori> findAllInventori() {
        return inventoriIRepository.findAll();
    }

    @Override
    public Inventori saveInven(Inventori inventori) {
        return inventoriIRepository.save(inventori);
    }

    @Override
    public void deleteInven(Integer inven) {
        inventoriIRepository.deleteById(inven);
    }
    
}
