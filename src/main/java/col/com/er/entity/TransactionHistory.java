package col.com.er.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction_history")
@XmlRootElement

public class TransactionHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "message")
    private String message;
    
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
    
    @JoinColumn(name = "Transaction_id", referencedColumnName = "transaction_id")
    @ManyToOne(optional = false)
    private TransactionCliente transactionid;
    
    @JoinColumn(name = "cState_transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    
    private CstateTransaction cStatetransactionid;

    public TransactionHistory() {
    }

    public TransactionHistory(Long id) {
        this.id = id;
    }

    public TransactionHistory(Long id, String message, Date createdAt, Date updateAt) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.TransactionHistory[ id=" + id + " ]";
    }
    
}
