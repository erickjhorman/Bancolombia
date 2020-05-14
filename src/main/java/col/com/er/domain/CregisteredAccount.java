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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cregistered_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CregisteredAccount.findAll", query = "SELECT c FROM CregisteredAccount c"),
    @NamedQuery(name = "CregisteredAccount.findById", query = "SELECT c FROM CregisteredAccount c WHERE c.id = :id"),
    @NamedQuery(name = "CregisteredAccount.findByName", query = "SELECT c FROM CregisteredAccount c WHERE c.name = :name"),
    @NamedQuery(name = "CregisteredAccount.findByAccountNumber", query = "SELECT c FROM CregisteredAccount c WHERE c.accountNumber = :accountNumber"),
    @NamedQuery(name = "CregisteredAccount.findByCreatedAt", query = "SELECT c FROM CregisteredAccount c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CregisteredAccount.findByUpdateAt", query = "SELECT c FROM CregisteredAccount c WHERE c.updateAt = :updateAt")})
public class CregisteredAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
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
    @JoinColumn(name = "Client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client clientid;
    @OneToMany(mappedBy = "clientRegisteredId")
    private List<TransactionCliente> transactionClienteList;

    public CregisteredAccount() {
    }

    public CregisteredAccount(Integer id) {
        this.id = id;
    }

    public CregisteredAccount(Integer id, String name, String accountNumber, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Client getClientid() {
        return clientid;
    }

    public void setClientid(Client clientid) {
        this.clientid = clientid;
    }

    @XmlTransient
    public List<TransactionCliente> getTransactionClienteList() {
        return transactionClienteList;
    }

    public void setTransactionClienteList(List<TransactionCliente> transactionClienteList) {
        this.transactionClienteList = transactionClienteList;
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
        if (!(object instanceof CregisteredAccount)) {
            return false;
        }
        CregisteredAccount other = (CregisteredAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.CregisteredAccount[ id=" + id + " ]";
    }
    
}
