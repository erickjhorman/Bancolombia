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
import javax.persistence.Lob;
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
@Table(name = "transaction_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionHistory.findAll", query = "SELECT t FROM TransactionHistory t"),
    @NamedQuery(name = "TransactionHistory.findById", query = "SELECT t FROM TransactionHistory t WHERE t.id = :id"),
    @NamedQuery(name = "TransactionHistory.findByCreatedAt", query = "SELECT t FROM TransactionHistory t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TransactionHistory.findByUpdateAt", query = "SELECT t FROM TransactionHistory t WHERE t.updateAt = :updateAt")})
public class TransactionHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "message")
    private String message;
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
    @JoinColumn(name = "Transaction_id", referencedColumnName = "transaction_id")
    @ManyToOne(optional = false)
    private TransactionCliente transactionid;
    @JoinColumn(name = "cState_transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateTransaction cStatetransactionid;

    public TransactionHistory() {
    }

    public TransactionHistory(Long id) {
        this.id = id;
    }

    public TransactionHistory(Long id, String message, Date createdAt, Date updateAt) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public TransactionCliente getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(TransactionCliente transactionid) {
        this.transactionid = transactionid;
    }

    public CstateTransaction getCStatetransactionid() {
        return cStatetransactionid;
    }

    public void setCStatetransactionid(CstateTransaction cStatetransactionid) {
        this.cStatetransactionid = cStatetransactionid;
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
        if (!(object instanceof TransactionHistory)) {
            return false;
        }
        TransactionHistory other = (TransactionHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.TransactionHistory[ id=" + id + " ]";
    }
    
}
