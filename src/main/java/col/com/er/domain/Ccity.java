/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author erick
 */
@Entity
@Table(name = "ccity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ccity.findAll", query = "SELECT c FROM Ccity c"),
    @NamedQuery(name = "Ccity.findById", query = "SELECT c FROM Ccity c WHERE c.id = :id"),
    @NamedQuery(name = "Ccity.findByCity", query = "SELECT c FROM Ccity c WHERE c.city = :city"),
    @NamedQuery(name = "Ccity.findByCreatedAt", query = "SELECT c FROM Ccity c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Ccity.findByUpdateAt", query = "SELECT c FROM Ccity c WHERE c.updateAt = :updateAt")})
public class Ccity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private List<Cdeparment> cdeparmentList;

    public Ccity() {
    }

    public Ccity(Integer id) {
        this.id = id;
    }

    public Ccity(Integer id, String city, Date createdAt, Date updateAt) {
        this.id = id;
        this.city = city;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @XmlTransient
    public List<Cdeparment> getCdeparmentList() {
        return cdeparmentList;
    }

    public void setCdeparmentList(List<Cdeparment> cdeparmentList) {
        this.cdeparmentList = cdeparmentList;
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
        if (!(object instanceof Ccity)) {
            return false;
        }
        Ccity other = (Ccity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Ccity[ id=" + id + " ]";
    }
    
}
