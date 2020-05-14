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
@Table(name = "description_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptionProducts.findAll", query = "SELECT d FROM DescriptionProducts d"),
    @NamedQuery(name = "DescriptionProducts.findById", query = "SELECT d FROM DescriptionProducts d WHERE d.id = :id"),
    @NamedQuery(name = "DescriptionProducts.findByPaymentsTime", query = "SELECT d FROM DescriptionProducts d WHERE d.paymentsTime = :paymentsTime"),
    @NamedQuery(name = "DescriptionProducts.findByHandlingFee", query = "SELECT d FROM DescriptionProducts d WHERE d.handlingFee = :handlingFee"),
    @NamedQuery(name = "DescriptionProducts.findByCreatedAt", query = "SELECT d FROM DescriptionProducts d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DescriptionProducts.findByUpdateAt", query = "SELECT d FROM DescriptionProducts d WHERE d.updateAt = :updateAt")})
public class DescriptionProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payments_time")
    private int paymentsTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "handling_fee")
    private short handlingFee;
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
    @JoinColumn(name = "csub_products_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CsubProducts csubProductsId;

    public DescriptionProducts() {
    }

    public DescriptionProducts(Integer id) {
        this.id = id;
    }

    public DescriptionProducts(Integer id, int paymentsTime, short handlingFee, Date createdAt, Date updateAt) {
        this.id = id;
        this.paymentsTime = paymentsTime;
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

    public int getPaymentsTime() {
        return paymentsTime;
    }

    public void setPaymentsTime(int paymentsTime) {
        this.paymentsTime = paymentsTime;
    }

    public short getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(short handlingFee) {
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

    public CsubProducts getCsubProductsId() {
        return csubProductsId;
    }

    public void setCsubProductsId(CsubProducts csubProductsId) {
        this.csubProductsId = csubProductsId;
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
        if (!(object instanceof DescriptionProducts)) {
            return false;
        }
        DescriptionProducts other = (DescriptionProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionProducts[ id=" + id + " ]";
    }
    
}
