/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iServiceImplement;

import asset.manajemen.asset.manajemen.iRepository.RekapInventoriDeptIRepository;
import asset.manajemen.asset.manajemen.iService.RekapInventoriDeptIService;
import asset.manajemen.asset.manajemen.model.RekapInventoriDept;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RRAAAA
 */
@Service
public class RekapInventoriDeptServiceImp implements RekapInventoriDeptIService {
    
    @Autowired
    private RekapInventoriDeptIRepository rekapInventoriDeptIRepository;
    
    @Override
    public Iterable<RekapInventoriDept> findAllRekap() {
        return rekapInventoriDeptIRepository.findAll();
    }

    @Override
    public RekapInventoriDept saveRekap(RekapInventoriDept rid) {
        return rekapInventoriDeptIRepository.save(rid);
    }

    @Override
    public Optional<RekapInventoriDept> findById(Integer id) {
        return rekapInventoriDeptIRepository.findById(id);
    }
    
}
