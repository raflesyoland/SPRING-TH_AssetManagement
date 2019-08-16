/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "inventori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventori.findAll", query = "SELECT i FROM Inventori i")
    , @NamedQuery(name = "Inventori.findById", query = "SELECT i FROM Inventori i WHERE i.id = :id")
    , @NamedQuery(name = "Inventori.findByNama", query = "SELECT i FROM Inventori i WHERE i.nama = :nama")
    , @NamedQuery(name = "Inventori.findByTglInput", query = "SELECT i FROM Inventori i WHERE i.tglInput = :tglInput")
    , @NamedQuery(name = "Inventori.findByTglUpdate", query = "SELECT i FROM Inventori i WHERE i.tglUpdate = :tglUpdate")
    , @NamedQuery(name = "Inventori.findByJumlahMasuk", query = "SELECT i FROM Inventori i WHERE i.jumlahMasuk = :jumlahMasuk")
    , @NamedQuery(name = "Inventori.findByJumlahKeluar", query = "SELECT i FROM Inventori i WHERE i.jumlahKeluar = :jumlahKeluar")
    , @NamedQuery(name = "Inventori.findByTotalBarang", query = "SELECT i FROM Inventori i WHERE i.totalBarang = :totalBarang")})
public class Inventori implements Serializable {

    @Column(name = "jumlah_masuk")
    private Integer jumlahMasuk;
    @Column(name = "jumlah_keluar")
    private Integer jumlahKeluar;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 90)
    @Column(name = "nama")
    private String nama;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "tgl_input")
    @Temporal(TemporalType.DATE)
    private Date tglInput;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "tgl_update")
    @Temporal(TemporalType.DATE)
    private Date tglUpdate;
    @Column(name = "total_barang")
    private Integer totalBarang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventori", fetch = FetchType.LAZY)
    private List<RekapInventoriDept> rekapInventoriDeptList;

    public Inventori() {
    }

    public Inventori(Integer id) {
        this.id = id;
    }

    public Inventori(Integer id, String nama, Date tglInput) {
        this.id = id;
        this.nama = nama;
        this.tglInput = tglInput;
    }

    public Inventori(String nama, Date tglInput) {
        this.nama = nama;
        this.tglInput = tglInput;
    }

    public Inventori(Integer id, String nama, Date tglInput, Date tglUpdate, int jumlahMasuk, int jumlahKeluar) {
        this.id = id;
        this.nama = nama;
        this.tglInput = tglInput;
        this.tglUpdate = tglUpdate;
        this.jumlahMasuk = jumlahMasuk;
        this.jumlahKeluar = jumlahKeluar;
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

    public Date getTglInput() {
        return tglInput;
    }

    public void setTglInput(Date tglInput) {
        this.tglInput = tglInput;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }

    public int getJumlahMasuk() {
        return jumlahMasuk;
    }

    public void setJumlahMasuk(int jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
    }

    public int getJumlahKeluar() {
        return jumlahKeluar;
    }

    public void setJumlahKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    public Integer getTotalBarang() {
        return totalBarang;
    }

    public void setTotalBarang(Integer totalBarang) {
        this.totalBarang = totalBarang;
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
        if (!(object instanceof Inventori)) {
            return false;
        }
        Inventori other = (Inventori) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "asset.manajemen.asset.manajemen.model.Inventori[ id=" + id + " ]";
    }

//    public Integer getJumlahMasuk() {
//        return jumlahMasuk;
//    }
//
//    public void setJumlahMasuk(Integer jumlahMasuk) {
//        this.jumlahMasuk = jumlahMasuk;
//    }
//
//    public Integer getJumlahKeluar() {
//        return jumlahKeluar;
//    }

    public void setJumlahKeluar(Integer jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }
    
}
