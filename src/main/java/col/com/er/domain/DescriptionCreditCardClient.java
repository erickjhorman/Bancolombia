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
@Table(name = "description_credit_card_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptionCreditCardClient.findAll", query = "SELECT d FROM DescriptionCreditCardClient d"),
    @NamedQuery(name = "DescriptionCreditCardClient.findById", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.id = :id"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByCardNumber", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.cardNumber = :cardNumber"),
    @NamedQuery(name = "DescriptionCreditCardClient.findBySecrityCode", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.secrityCode = :secrityCode"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByExpirationDate", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.expirationDate = :expirationDate"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByName", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.name = :name"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByAmount", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.amount = :amount"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByInterestRate", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.interestRate = :interestRate"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByHandlingFee", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.handlingFee = :handlingFee"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByCreatedAt", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DescriptionCreditCardClient.findByUpdateAt", query = "SELECT d FROM DescriptionCreditCardClient d WHERE d.updateAt = :updateAt")})
public class DescriptionCreditCardClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "card_number")
    private String cardNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "secrity_code")
    private String secrityCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest_rate")
    private double interestRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "handling_fee")
    private int handlingFee;
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
    @JoinColumn(name = "type_card_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeCard typeCardId;

    public DescriptionCreditCardClient() {
    }

    public DescriptionCreditCardClient(Integer id) {
        this.id = id;
    }

    public DescriptionCreditCardClient(Integer id, String cardNumber, String secrityCode, Date expirationDate, String name, int amount, double interestRate, int handlingFee, Date createdAt, Date updateAt) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.secrityCode = secrityCode;
        this.expirationDate = expirationDate;
        this.name = name;
        this.amount = amount;
        this.interestRate = interestRate;
        this.handlingFee = handlingFee;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecrityCode() {
        return secrityCode;
    }

    public void setSecrityCode(String secrityCode) {
        this.secrityCode = secrityCode;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(int handlingFee) {
        this.handlingFee = handlingFee;
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

    public TypeCard getTypeCardId() {
        return typeCardId;
    }

    public void setTypeCardId(TypeCard typeCardId) {
        this.typeCardId = typeCardId;
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
        if (!(object instanceof DescriptionCreditCardClient)) {
            return false;
        }
        DescriptionCreditCardClient other = (DescriptionCreditCardClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionCreditCardClient[ id=" + id + " ]";
    }
    
}
