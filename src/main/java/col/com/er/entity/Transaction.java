
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
@Table(name = "transaction")
@XmlRootElement

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

   

    @Override
    public String toString() {
        return "col.com.er.domain.Transaction[ id=" + id + " ]";
    }
    
}
