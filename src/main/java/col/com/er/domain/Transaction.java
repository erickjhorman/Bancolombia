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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id"),
    @NamedQuery(name = "Transaction.findByCode", query = "SELECT t FROM Transaction t WHERE t.code = :code"),
    @NamedQuery(name = "Transaction.findByCreatedAt", query = "SELECT t FROM Transaction t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "Transaction.findByUpdateAt", query = "SELECT t FROM Transaction t WHERE t.updateAt = :updateAt")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "code")
    private String code;
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
    private List<TransactionCliente> transactionClienteList;
    @JoinColumn(name = "cState_transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateTransaction cStatetransactionid;
    @JoinColumn(name = "cTypeTransactio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ctypetransactio cTypeTransactioid;
    @JoinColumn(name = "cType_Error_id", referencedColumnName = "idcType_Error")
    @ManyToOne
    private CtypeError cTypeErrorid;

    public Transaction() {
    }

    public Transaction(Long id) {
        this.id = id;
    }

    public Transaction(Long id, String code, Date createdAt, Date updateAt) {
        this.id = id;
        this.code = code;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public List<TransactionCliente> getTransactionClienteList() {
        return transactionClienteList;
    }

    public void setTransactionClienteList(List<TransactionCliente> transactionClienteList) {
        this.transactionClienteList = transactionClienteList;
    }

    public CstateTransaction getCStatetransactionid() {
        return cStatetransactionid;
    }

    public void setCStatetransactionid(CstateTransaction cStatetransactionid) {
        this.cStatetransactionid = cStatetransactionid;
    }

    public Ctypetransactio getCTypeTransactioid() {
        return cTypeTransactioid;
    }

    public void setCTypeTransactioid(Ctypetransactio cTypeTransactioid) {
        this.cTypeTransactioid = cTypeTransactioid;
    }

    public CtypeError getCTypeErrorid() {
        return cTypeErrorid;
    }

    public void setCTypeErrorid(CtypeError cTypeErrorid) {
        this.cTypeErrorid = cTypeErrorid;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Transaction[ id=" + id + " ]";
    }
    
}
