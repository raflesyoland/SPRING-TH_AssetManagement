/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iServiceImplement;

import asset.manajemen.asset.manajemen.iRepository.DepartemenIRepository;
import asset.manajemen.asset.manajemen.iService.DeptIService;
import asset.manajemen.asset.manajemen.model.Departemen;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RRAAAA
 */
@Service
public class DeptServiceImp implements DeptIService {
    
    @Autowired
    private DepartemenIRepository departemenIRepository;

    @Override
    public Iterable<Departemen> findAllAkses() {
        return departemenIRepository.findAll();
    }

    @Override
    public Departemen saveDept(Departemen departemen) {
        return departemenIRepository.save(departemen);
    }

    @Override
    public void deleteDept(Integer dept) {
        departemenIRepository.deleteById(dept);
    }

    @Override
    public Optional<Departemen> findById(Integer id) {
        return departemenIRepository.findById(id);
    }
    
}
