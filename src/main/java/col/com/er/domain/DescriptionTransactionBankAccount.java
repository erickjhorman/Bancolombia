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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "description_transaction_bank_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptionTransactionBankAccount.findAll", query = "SELECT d FROM DescriptionTransactionBankAccount d"),
    @NamedQuery(name = "DescriptionTransactionBankAccount.findById", query = "SELECT d FROM DescriptionTransactionBankAccount d WHERE d.id = :id"),
    @NamedQuery(name = "DescriptionTransactionBankAccount.findByAmount", query = "SELECT d FROM DescriptionTransactionBankAccount d WHERE d.amount = :amount"),
    @NamedQuery(name = "DescriptionTransactionBankAccount.findByCreatedAt", query = "SELECT d FROM DescriptionTransactionBankAccount d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DescriptionTransactionBankAccount.findByUpdateAt", query = "SELECT d FROM DescriptionTransactionBankAccount d WHERE d.updateAt = :updateAt")})
public class DescriptionTransactionBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
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
    @JoinColumn(name = "transcation_id", referencedColumnName = "transaction_id")
    @ManyToOne(optional = false)
    private TransactionCliente transcationId;

    public DescriptionTransactionBankAccount() {
    }

    public DescriptionTransactionBankAccount(Long id) {
        this.id = id;
    }

    public DescriptionTransactionBankAccount(Long id, int amount, Date createdAt, Date updateAt) {
        this.id = id;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public TransactionCliente getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(TransactionCliente transcationId) {
        this.transcationId = transcationId;
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
        if (!(object instanceof DescriptionTransactionBankAccount)) {
            return false;
        }
        DescriptionTransactionBankAccount other = (DescriptionTransactionBankAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionTransactionBankAccount[ id=" + id + " ]";
    }
    
}
