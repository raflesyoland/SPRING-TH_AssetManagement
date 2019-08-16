/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RRAAAA
 */
@Entity
@Table(name = "akses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Akses.findAll", query = "SELECT a FROM Akses a")
    , @NamedQuery(name = "Akses.findById", query = "SELECT a FROM Akses a WHERE a.id = :id")
    , @NamedQuery(name = "Akses.findByUsername", query = "SELECT a FROM Akses a WHERE a.username = :username")
    , @NamedQuery(name = "Akses.findByPassword", query = "SELECT a FROM Akses a WHERE a.password = :password")})
public class Akses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 90)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 90)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;

    public Akses() {
    }

    public Akses(Integer id) {
        this.id = id;
    }

    public Akses(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        if (!(object instanceof Akses)) {
            return false;
        }
        Akses other = (Akses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "asset.manajemen.asset.manajemen.model.Akses[ id=" + id + " ]";
    }
    
}
