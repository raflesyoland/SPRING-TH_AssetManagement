/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.iService;

import asset.manajemen.asset.manajemen.model.Inventori;

/**
 *
 * @author RRAAAA
 */
public interface InventoriIService {
    Iterable<Inventori> findAllInventori();
    Inventori saveInven(Inventori inventori);
    void deleteInven(Integer inven);
}
