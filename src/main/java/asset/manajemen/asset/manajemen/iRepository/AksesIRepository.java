/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iRepository;

import asset.manajemen.asset.manajemen.model.Akses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RRAAAA
 */
@Repository
public interface AksesIRepository extends CrudRepository<Akses, Integer>{
    
}
