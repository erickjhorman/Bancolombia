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
@Table(name = "ctype_error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtypeError.findAll", query = "SELECT c FROM CtypeError c"),
    @NamedQuery(name = "CtypeError.findByIdcTypeError", query = "SELECT c FROM CtypeError c WHERE c.idcTypeError = :idcTypeError"),
    @NamedQuery(name = "CtypeError.findByName", query = "SELECT c FROM CtypeError c WHERE c.name = :name"),
    @NamedQuery(name = "CtypeError.findByCreatedAt", query = "SELECT c FROM CtypeError c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CtypeError.findByUpdateAt", query = "SELECT c FROM CtypeError c WHERE c.updateAt = :updateAt")})
public class CtypeError implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcType_Error")
    private Integer idcTypeError;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
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
    @OneToMany(mappedBy = "cTypeErrorid")
    private List<Transaction> transactionList;

    public CtypeError() {
    }

    public CtypeError(Integer idcTypeError) {
        this.idcTypeError = idcTypeError;
    }

    public CtypeError(Integer idcTypeError, String name, Date createdAt, Date updateAt) {
        this.idcTypeError = idcTypeError;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getIdcTypeError() {
        return idcTypeError;
    }

    public void setIdcTypeError(Integer idcTypeError) {
        this.idcTypeError = idcTypeError;
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
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcTypeError != null ? idcTypeError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtypeError)) {
            return false;
        }
        CtypeError other = (CtypeError) object;
        if ((this.idcTypeError == null && other.idcTypeError != null) || (this.idcTypeError != null && !this.idcTypeError.equals(other.idcTypeError))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.CtypeError[ idcTypeError=" + idcTypeError + " ]";
    }
    
}
