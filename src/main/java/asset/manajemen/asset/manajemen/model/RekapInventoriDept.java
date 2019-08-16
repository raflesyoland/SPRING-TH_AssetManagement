/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "rekap_inventori_dept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RekapInventoriDept.findAll", query = "SELECT r FROM RekapInventoriDept r")
    , @NamedQuery(name = "RekapInventoriDept.findById", query = "SELECT r FROM RekapInventoriDept r WHERE r.id = :id")
    , @NamedQuery(name = "RekapInventoriDept.findByJumlahKeluar", query = "SELECT r FROM RekapInventoriDept r WHERE r.jumlahKeluar = :jumlahKeluar")
    , @NamedQuery(name = "RekapInventoriDept.findByJumlahDeptMasuk", query = "SELECT r FROM RekapInventoriDept r WHERE r.jumlahDeptMasuk = :jumlahDeptMasuk")
    , @NamedQuery(name = "RekapInventoriDept.findByJumlahDeptKeluar", query = "SELECT r FROM RekapInventoriDept r WHERE r.jumlahDeptKeluar = :jumlahDeptKeluar")
    , @NamedQuery(name = "RekapInventoriDept.findByKeterangan", query = "SELECT r FROM RekapInventoriDept r WHERE r.keterangan = :keterangan")
    , @NamedQuery(name = "RekapInventoriDept.findByStatus", query = "SELECT r FROM RekapInventoriDept r WHERE r.status = :status")
    , @NamedQuery(name = "RekapInventoriDept.findByTglMasuk", query = "SELECT r FROM RekapInventoriDept r WHERE r.tglMasuk = :tglMasuk")
    , @NamedQuery(name = "RekapInventoriDept.findByTglUpdate", query = "SELECT r FROM RekapInventoriDept r WHERE r.tglUpdate = :tglUpdate")})
public class RekapInventoriDept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "jumlah_keluar")
    private int jumlahKeluar;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "jumlah_dept_masuk")
    private int jumlahDeptMasuk;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "jumlah_dept_keluar")
    private int jumlahDeptKeluar;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 150)
    @Column(name = "keterangan")
    private String keterangan;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "status")
    private int status;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "tgl_masuk")
    @Temporal(TemporalType.DATE)
    private Date tglMasuk;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "tgl_update")
    @Temporal(TemporalType.DATE)
    private Date tglUpdate;
    @JoinColumn(name = "departemen", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departemen departemen;
    @JoinColumn(name = "inventori", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventori inventori;

    public RekapInventoriDept() {
    }

    public RekapInventoriDept(Integer id) {
        this.id = id;
    }

    public RekapInventoriDept(Departemen departemen, Inventori inventori, Date tglMasuk, Date tglUpdate, int jumlahKeluar, int jumlahDeptMasuk, String keterangan, int status) {
        this.jumlahKeluar = jumlahKeluar;
        this.jumlahDeptMasuk = jumlahDeptMasuk;
        this.keterangan = keterangan;
        this.status = status;
        this.tglMasuk = tglMasuk;
        this.tglUpdate = tglUpdate;
        this.departemen = departemen;
        this.inventori = inventori;
    }

    public RekapInventoriDept(Integer id, int jumlahKeluar, int jumlahDeptMasuk, int jumlahDeptKeluar, String keterangan, int status, Date tglMasuk, Date tglUpdate) {
        this.id = id;
        this.jumlahKeluar = jumlahKeluar;
        this.jumlahDeptMasuk = jumlahDeptMasuk;
        this.jumlahDeptKeluar = jumlahDeptKeluar;
        this.keterangan = keterangan;
        this.status = status;
        this.tglMasuk = tglMasuk;
        this.tglUpdate = tglUpdate;
    }

    public RekapInventoriDept(Integer id, int jumlahKeluar, int jumlahDeptMasuk, int jumlahDeptKeluar, String keterangan, int status, Date tglMasuk, Date tglUpdate, Departemen departemen, Inventori inventori) {
        this.id = id;
        this.jumlahKeluar = jumlahKeluar;
        this.jumlahDeptMasuk = jumlahDeptMasuk;
        this.jumlahDeptKeluar = jumlahDeptKeluar;
        this.keterangan = keterangan;
        this.status = status;
        this.tglMasuk = tglMasuk;
        this.tglUpdate = tglUpdate;
        this.departemen = departemen;
        this.inventori = inventori;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJumlahKeluar() {
        return jumlahKeluar;
    }

    public void setJumlahKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    public int getJumlahDeptMasuk() {
        return jumlahDeptMasuk;
    }

    public void setJumlahDeptMasuk(int jumlahDeptMasuk) {
        this.jumlahDeptMasuk = jumlahDeptMasuk;
    }

    public int getJumlahDeptKeluar() {
        return jumlahDeptKeluar;
    }

    public void setJumlahDeptKeluar(int jumlahDeptKeluar) {
        this.jumlahDeptKeluar = jumlahDeptKeluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }

    public Departemen getDepartemen() {
        return departemen;
    }

    public void setDepartemen(Departemen departemen) {
        this.departemen = departemen;
    }

    public Inventori getInventori() {
        return inventori;
    }

    public void setInventori(Inventori inventori) {
        this.inventori = inventori;
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
        if (!(object instanceof RekapInventoriDept)) {
            return false;
        }
        RekapInventoriDept other = (RekapInventoriDept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "asset.manajemen.asset.manajemen.model.RekapInventoriDept[ id=" + id + " ]";
    }
    
}
