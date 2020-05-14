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
@Table(name = "cstate_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CstateTransaction.findAll", query = "SELECT c FROM CstateTransaction c"),
    @NamedQuery(name = "CstateTransaction.findById", query = "SELECT c FROM CstateTransaction c WHERE c.id = :id"),
    @NamedQuery(name = "CstateTransaction.findByName", query = "SELECT c FROM CstateTransaction c WHERE c.name = :name"),
    @NamedQuery(name = "CstateTransaction.findByCreatedAt", query = "SELECT c FROM CstateTransaction c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CstateTransaction.findByUpdateAt", query = "SELECT c FROM CstateTransaction c WHERE c.updateAt = :updateAt")})
public class CstateTransaction implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStatetransactionid")
    private List<TransactionHistory> transactionHistoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStatetransactionid")
    private List<TransactionCliente> transactionClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStatetransactionid")
    private List<Transaction> transactionList;

    public CstateTransaction() {
    }

    public CstateTransaction(Integer id) {
        this.id = id;
    }

    public CstateTransaction(Integer id, String name, Date createdAt, Date updateAt) {
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
    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }

    @XmlTransient
    public List<TransactionCliente> getTransactionClienteList() {
        return transactionClienteList;
    }

    public void setTransactionClienteList(List<TransactionCliente> transactionClienteList) {
        this.transactionClienteList = transactionClienteList;
    }

    @XmlTransient
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
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
        if (!(object instanceof CstateTransaction)) {
            return false;
        }
        CstateTransaction other = (CstateTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.CstateTransaction[ id=" + id + " ]";
    }
    
}
