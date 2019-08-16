/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "departemen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departemen.findAll", query = "SELECT d FROM Departemen d")
    , @NamedQuery(name = "Departemen.findById", query = "SELECT d FROM Departemen d WHERE d.id = :id")
    , @NamedQuery(name = "Departemen.findByNama", query = "SELECT d FROM Departemen d WHERE d.nama = :nama")})
public class Departemen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @JoinColumn(name = "divisi", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Divisi divisi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departemen", fetch = FetchType.LAZY)
    private List<RekapInventoriDept> rekapInventoriDeptList;

    public Departemen() {
    }

    public Departemen(Integer id) {
        this.id = id;
    }

    public Departemen(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Departemen(Integer id, String nama, Divisi divisi) {
        this.id = id;
        this.nama = nama;
        this.divisi = divisi;
    }

    public Departemen(String nama, Divisi divisi) {
        this.nama = nama;
        this.divisi = divisi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Divisi getDivisi() {
        return divisi;
    }

    public void setDivisi(Divisi divisi) {
        this.divisi = divisi;
    }

    @XmlTransient
    public List<RekapInventoriDept> getRekapInventoriDeptList() {
        return rekapInventoriDeptList;
    }

    public void setRekapInventoriDeptList(List<RekapInventoriDept> rekapInventoriDeptList) {
        this.rekapInventoriDeptList = rekapInventoriDeptList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departemen)) {
            return false;
        }
        Departemen other = (Departemen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "asset.manajemen.asset.manajemen.model.Departemen[ id=" + id + " ]";
    }
    
}
