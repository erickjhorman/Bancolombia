/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Data
@Entity
@Table(name = "cbanks")
@XmlRootElement

public class Cbanks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
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
    
    /*
    @OneToMany()
    @JoinColumn(name="cBanks_id")
    
    private List<DescriptionTransactionOthersBanks> descriptionTransactionOthersBanksList;
    */
    public Cbanks() {
    }

    public Cbanks(Long id, Date createdAt, Date updateAt, List<DescriptionTransactionOthersBanks> descriptionTransactionOthersBanksList) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        //this.descriptionTransactionOthersBanksList = descriptionTransactionOthersBanksList;
    }

    
    /*
    @XmlTransient
    public List<DescriptionTransactionOthersBanks> getDescriptionTransactionOthersBanksList() {
        return descriptionTransactionOthersBanksList;
    }

    public void setDescriptionTransactionOthersBanksList(List<DescriptionTransactionOthersBanks> descriptionTransactionOthersBanksList) {
        this.descriptionTransactionOthersBanksList = descriptionTransactionOthersBanksList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbanks)) {
            return false;
        }
        Cbanks other = (Cbanks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Cbanks[ id=" + id + " ]";
    }
    
}
