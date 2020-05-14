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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "description_account_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptionAccountClient.findAll", query = "SELECT d FROM DescriptionAccountClient d"),
    @NamedQuery(name = "DescriptionAccountClient.findById", query = "SELECT d FROM DescriptionAccountClient d WHERE d.id = :id"),
    @NamedQuery(name = "DescriptionAccountClient.findByAccountNumber", query = "SELECT d FROM DescriptionAccountClient d WHERE d.accountNumber = :accountNumber"),
    @NamedQuery(name = "DescriptionAccountClient.findByCreatedAt", query = "SELECT d FROM DescriptionAccountClient d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DescriptionAccountClient.findByUpdateAt", query = "SELECT d FROM DescriptionAccountClient d WHERE d.updateAt = :updateAt")})
public class DescriptionAccountClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "account_number")
    private String accountNumber;
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
    @JoinColumn(name = "cState_product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateProduct cStateproductid;
    @JoinColumn(name = "client_products", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientProducts clientProducts;

    public DescriptionAccountClient() {
    }

    public DescriptionAccountClient(Integer id) {
        this.id = id;
    }

    public DescriptionAccountClient(Integer id, String accountNumber, Date createdAt, Date updateAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public CstateProduct getCStateproductid() {
        return cStateproductid;
    }

    public void setCStateproductid(CstateProduct cStateproductid) {
        this.cStateproductid = cStateproductid;
    }

    public ClientProducts getClientProducts() {
        return clientProducts;
    }

    public void setClientProducts(ClientProducts clientProducts) {
        this.clientProducts = clientProducts;
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
        if (!(object instanceof DescriptionAccountClient)) {
            return false;
        }
        DescriptionAccountClient other = (DescriptionAccountClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionAccountClient[ id=" + id + " ]";
    }
    
}
