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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "transaction_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionCliente.findAll", query = "SELECT t FROM TransactionCliente t"),
    @NamedQuery(name = "TransactionCliente.findById", query = "SELECT t FROM TransactionCliente t WHERE t.id = :id"),
    @NamedQuery(name = "TransactionCliente.findByCreatedAt", query = "SELECT t FROM TransactionCliente t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TransactionCliente.findByUpdateAt", query = "SELECT t FROM TransactionCliente t WHERE t.updateAt = :updateAt")})
public class TransactionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionId")
    private List<DescriptionTransactionOthersBanks> descriptionTransactionOthersBanksList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionid")
    private List<TransactionHistory> transactionHistoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transcationId")
    private List<DescriptionTransactionBankAccount> descriptionTransactionBankAccountList;
    @JoinColumn(name = "cState_transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateTransaction cStatetransactionid;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client clientId;
    @JoinColumn(name = "client1_id", referencedColumnName = "id")
    @ManyToOne
    private Client client1Id;
    @JoinColumn(name = "client_registered_id", referencedColumnName = "id")
    @ManyToOne
    private CregisteredAccount clientRegisteredId;
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;

    public TransactionCliente() {
    }

    public TransactionCliente(Long id) {
        this.id = id;
    }

    public TransactionCliente(Long id, Date createdAt, Date updateAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public List<DescriptionTransactionOthersBanks> getDescriptionTransactionOthersBanksList() {
        return descriptionTransactionOthersBanksList;
    }

    public void setDescriptionTransactionOthersBanksList(List<DescriptionTransactionOthersBanks> descriptionTransactionOthersBanksList) {
        this.descriptionTransactionOthersBanksList = descriptionTransactionOthersBanksList;
    }

    @XmlTransient
    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }

    @XmlTransient
    public List<DescriptionTransactionBankAccount> getDescriptionTransactionBankAccountList() {
        return descriptionTransactionBankAccountList;
    }

    public void setDescriptionTransactionBankAccountList(List<DescriptionTransactionBankAccount> descriptionTransactionBankAccountList) {
        this.descriptionTransactionBankAccountList = descriptionTransactionBankAccountList;
    }

    public CstateTransaction getCStatetransactionid() {
        return cStatetransactionid;
    }

    public void setCStatetransactionid(CstateTransaction cStatetransactionid) {
        this.cStatetransactionid = cStatetransactionid;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Client getClient1Id() {
        return client1Id;
    }

    public void setClient1Id(Client client1Id) {
        this.client1Id = client1Id;
    }

    public CregisteredAccount getClientRegisteredId() {
        return clientRegisteredId;
    }

    public void setClientRegisteredId(CregisteredAccount clientRegisteredId) {
        this.clientRegisteredId = clientRegisteredId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
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
        if (!(object instanceof TransactionCliente)) {
            return false;
        }
        TransactionCliente other = (TransactionCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.TransactionCliente[ id=" + id + " ]";
    }
    
}
