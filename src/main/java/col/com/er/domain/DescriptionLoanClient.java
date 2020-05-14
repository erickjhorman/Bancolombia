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
@Table(name = "description_loan_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptionLoanClient.findAll", query = "SELECT d FROM DescriptionLoanClient d"),
    @NamedQuery(name = "DescriptionLoanClient.findById", query = "SELECT d FROM DescriptionLoanClient d WHERE d.id = :id"),
    @NamedQuery(name = "DescriptionLoanClient.findByLoanNumber", query = "SELECT d FROM DescriptionLoanClient d WHERE d.loanNumber = :loanNumber"),
    @NamedQuery(name = "DescriptionLoanClient.findByPaymentsNumber", query = "SELECT d FROM DescriptionLoanClient d WHERE d.paymentsNumber = :paymentsNumber"),
    @NamedQuery(name = "DescriptionLoanClient.findByAmount", query = "SELECT d FROM DescriptionLoanClient d WHERE d.amount = :amount"),
    @NamedQuery(name = "DescriptionLoanClient.findByCreatedAt", query = "SELECT d FROM DescriptionLoanClient d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DescriptionLoanClient.findByUpdateAt", query = "SELECT d FROM DescriptionLoanClient d WHERE d.updateAt = :updateAt")})
public class DescriptionLoanClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "loan_number")
    private String loanNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "payments_number")
    private String paymentsNumber;
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
    @JoinColumn(name = "cState_product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateProduct cStateproductid;
    @JoinColumn(name = "client_products", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientProducts clientProducts;

    public DescriptionLoanClient() {
    }

    public DescriptionLoanClient(Integer id) {
        this.id = id;
    }

    public DescriptionLoanClient(Integer id, String loanNumber, String paymentsNumber, int amount, Date createdAt, Date updateAt) {
        this.id = id;
        this.loanNumber = loanNumber;
        this.paymentsNumber = paymentsNumber;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getPaymentsNumber() {
        return paymentsNumber;
    }

    public void setPaymentsNumber(String paymentsNumber) {
        this.paymentsNumber = paymentsNumber;
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
        if (!(object instanceof DescriptionLoanClient)) {
            return false;
        }
        DescriptionLoanClient other = (DescriptionLoanClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionLoanClient[ id=" + id + " ]";
    }
    
}
