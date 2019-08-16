/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iService;

import asset.manajemen.asset.manajemen.model.RekapInventoriDept;
import java.util.Optional;

/**
 *
 * @author RRAAAA
 */
public interface RekapInventoriDeptIService {
    Iterable<RekapInventoriDept> findAllRekap();
    RekapInventoriDept saveRekap(RekapInventoriDept rid);
    Optional<RekapInventoriDept> findById(Integer id);
}
