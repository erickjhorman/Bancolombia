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
@Table(name = "type_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeCard.findAll", query = "SELECT t FROM TypeCard t"),
    @NamedQuery(name = "TypeCard.findById", query = "SELECT t FROM TypeCard t WHERE t.id = :id"),
    @NamedQuery(name = "TypeCard.findByName", query = "SELECT t FROM TypeCard t WHERE t.name = :name"),
    @NamedQuery(name = "TypeCard.findByCreatedAt", query = "SELECT t FROM TypeCard t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TypeCard.findByUpdateAt", query = "SELECT t FROM TypeCard t WHERE t.updateAt = :updateAt")})
public class TypeCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeCardId")
    private List<DescriptionCreditCardClient> descriptionCreditCardClientList;

    public TypeCard() {
    }

    public TypeCard(Integer id) {
        this.id = id;
    }

    public TypeCard(Integer id, String name, Date createdAt, Date updateAt) {
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
    public List<DescriptionCreditCardClient> getDescriptionCreditCardClientList() {
        return descriptionCreditCardClientList;
    }

    public void setDescriptionCreditCardClientList(List<DescriptionCreditCardClient> descriptionCreditCardClientList) {
        this.descriptionCreditCardClientList = descriptionCreditCardClientList;
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
        if (!(object instanceof TypeCard)) {
            return false;
        }
        TypeCard other = (TypeCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.TypeCard[ id=" + id + " ]";
    }
    
}
