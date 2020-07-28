
package col.com.er.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

@Data
@Entity
@Table(name = "cstate_transaction")
@XmlRootElement

public class CstateTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStatetransactionid")
    private List<TransactionHistory> transactionHistoryList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStatetransactionid")
    private List<TransactionCliente> transactionClienteList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStatetransactionid")
    private List<Transaction> transactionList;

    public CstateTransaction() {
    }

    public CstateTransaction(Integer id) {
        this.id = id;
    }

    public CstateTransaction(Integer id, String name, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.CstateTransaction[ id=" + id + " ]";
    }
    
}
