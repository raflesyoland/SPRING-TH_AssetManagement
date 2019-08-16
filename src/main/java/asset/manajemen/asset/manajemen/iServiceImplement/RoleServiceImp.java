/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iServiceImplement;

import asset.manajemen.asset.manajemen.iRepository.RoleIRepository;
import asset.manajemen.asset.manajemen.iService.RoleIService;
import asset.manajemen.asset.manajemen.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RRAAAA
 */
@Service
public class RoleServiceImp implements RoleIService{
    
    @Autowired
    private RoleIRepository roleIRepository;

    @Override
    public Iterable<Role> findAllRole() {
        return roleIRepository.findAll();
    }
}
