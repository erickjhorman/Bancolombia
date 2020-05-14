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
@Table(name = "cstate_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CstateProduct.findAll", query = "SELECT c FROM CstateProduct c"),
    @NamedQuery(name = "CstateProduct.findById", query = "SELECT c FROM CstateProduct c WHERE c.id = :id"),
    @NamedQuery(name = "CstateProduct.findByName", query = "SELECT c FROM CstateProduct c WHERE c.name = :name"),
    @NamedQuery(name = "CstateProduct.findByCreatedAt", query = "SELECT c FROM CstateProduct c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CstateProduct.findByUpdateAt", query = "SELECT c FROM CstateProduct c WHERE c.updateAt = :updateAt")})
public class CstateProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStateproductid")
    private List<DescriptionLoanClient> descriptionLoanClientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStateproductid")
    private List<DescriptionCreditCardClient> descriptionCreditCardClientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStateproductid")
    private List<DescriptionAccountClient> descriptionAccountClientList;

    public CstateProduct() {
    }

    public CstateProduct(Integer id) {
        this.id = id;
    }

    public CstateProduct(Integer id, String name, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public List<DescriptionLoanClient> getDescriptionLoanClientList() {
        return descriptionLoanClientList;
    }

    public void setDescriptionLoanClientList(List<DescriptionLoanClient> descriptionLoanClientList) {
        this.descriptionLoanClientList = descriptionLoanClientList;
    }

    @XmlTransient
    public List<DescriptionCreditCardClient> getDescriptionCreditCardClientList() {
        return descriptionCreditCardClientList;
    }

    public void setDescriptionCreditCardClientList(List<DescriptionCreditCardClient> descriptionCreditCardClientList) {
        this.descriptionCreditCardClientList = descriptionCreditCardClientList;
    }

    @XmlTransient
    public List<DescriptionAccountClient> getDescriptionAccountClientList() {
        return descriptionAccountClientList;
    }

    public void setDescriptionAccountClientList(List<DescriptionAccountClient> descriptionAccountClientList) {
        this.descriptionAccountClientList = descriptionAccountClientList;
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
        if (!(object instanceof CstateProduct)) {
            return false;
        }
        CstateProduct other = (CstateProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.CstateProduct[ id=" + id + " ]";
    }
    
}
