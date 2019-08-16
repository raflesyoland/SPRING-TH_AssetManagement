/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iServiceImplement;

import asset.manajemen.asset.manajemen.iRepository.DivisiIRepository;
import asset.manajemen.asset.manajemen.iService.DivisiIService;
import asset.manajemen.asset.manajemen.model.Divisi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RRAAAA
 */
@Service
public class DivisiServiceImp implements DivisiIService{
    
    @Autowired
    private DivisiIRepository divisiIRepository;

    @Override
    public Iterable<Divisi> findAllDivisi() {
        return divisiIRepository.findAll();
    }
    
}
