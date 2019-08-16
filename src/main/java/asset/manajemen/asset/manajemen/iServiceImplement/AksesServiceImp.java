/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iServiceImplement;

import asset.manajemen.asset.manajemen.iRepository.AksesIRepository;
import asset.manajemen.asset.manajemen.iService.AksesIService;
import asset.manajemen.asset.manajemen.model.Akses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RRAAAA
 */
@Service
public class AksesServiceImp implements AksesIService {
    
    @Autowired
    private AksesIRepository aksesIRepository;

    @Override
    public Iterable<Akses> findAllAkses() {
        return aksesIRepository.findAll();
    }
    
}
