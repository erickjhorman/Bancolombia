/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "cproducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cproducts.findAll", query = "SELECT c FROM Cproducts c"),
    @NamedQuery(name = "Cproducts.findById", query = "SELECT c FROM Cproducts c WHERE c.id = :id"),
    @NamedQuery(name = "Cproducts.findByProduct", query = "SELECT c FROM Cproducts c WHERE c.product = :product"),
    @NamedQuery(name = "Cproducts.findByCreatedAt", query = "SELECT c FROM Cproducts c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Cproducts.findByUpdateAt", query = "SELECT c FROM Cproducts c WHERE c.updateAt = :updateAt")})
public class Cproducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "product")
    private String product;
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

    public Cproducts() {
    }

    public Cproducts(Integer id) {
        this.id = id;
    }

    public Cproducts(Integer id, String product, Date createdAt, Date updateAt) {
        this.id = id;
        this.product = product;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cproducts)) {
            return false;
        }
        Cproducts other = (Cproducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Cproducts[ id=" + id + " ]";
    }
    
}
