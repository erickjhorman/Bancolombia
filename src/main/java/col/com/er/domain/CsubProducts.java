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
@Table(name = "csub_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsubProducts.findAll", query = "SELECT c FROM CsubProducts c"),
    @NamedQuery(name = "CsubProducts.findById", query = "SELECT c FROM CsubProducts c WHERE c.id = :id"),
    @NamedQuery(name = "CsubProducts.findByProductsId", query = "SELECT c FROM CsubProducts c WHERE c.productsId = :productsId"),
    @NamedQuery(name = "CsubProducts.findBySubProduct", query = "SELECT c FROM CsubProducts c WHERE c.subProduct = :subProduct"),
    @NamedQuery(name = "CsubProducts.findByCreatedAt", query = "SELECT c FROM CsubProducts c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CsubProducts.findByUpdateAt", query = "SELECT c FROM CsubProducts c WHERE c.updateAt = :updateAt")})
public class CsubProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "products_id")
    private int productsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "sub_product")
    private String subProduct;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subProductsId")
    private List<ClientProducts> clientProductsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "csubProductsId")
    private List<DescriptionProducts> descriptionProductsList;

    public CsubProducts() {
    }

    public CsubProducts(Integer id) {
        this.id = id;
    }

    public CsubProducts(Integer id, int productsId, String subProduct, Date createdAt, Date updateAt) {
        this.id = id;
        this.productsId = productsId;
        this.subProduct = subProduct;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
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
    public List<ClientProducts> getClientProductsList() {
        return clientProductsList;
    }

    public void setClientProductsList(List<ClientProducts> clientProductsList) {
        this.clientProductsList = clientProductsList;
    }

    @XmlTransient
    public List<DescriptionProducts> getDescriptionProductsList() {
        return descriptionProductsList;
    }

    public void setDescriptionProductsList(List<DescriptionProducts> descriptionProductsList) {
        this.descriptionProductsList = descriptionProductsList;
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
        if (!(object instanceof CsubProducts)) {
            return false;
        }
        CsubProducts other = (CsubProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.CsubProducts[ id=" + id + " ]";
    }
    
}
