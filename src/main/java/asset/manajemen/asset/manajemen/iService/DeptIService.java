/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iService;

import asset.manajemen.asset.manajemen.model.Departemen;
import java.util.Optional;

/**
 *
 * @author RRAAAA
 */
public interface DeptIService {
    Iterable<Departemen> findAllAkses();
    Departemen saveDept(Departemen departemen);
    void deleteDept(Integer dept);
    Optional<Departemen> findById(Integer id);
}
