
package col.com.er.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "description_transaction_bank_account")
@XmlRootElement

public class DescriptionTransactionBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
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
    
    @JoinColumn(name = "transcation_id", referencedColumnName = "transaction_id")
    @ManyToOne(optional = false)
    private TransactionCliente transcationId;

    public DescriptionTransactionBankAccount() {
    }

    public DescriptionTransactionBankAccount(Long id) {
        this.id = id;
    }

    public DescriptionTransactionBankAccount(Long id, int amount, Date createdAt, Date updateAt) {
        this.id = id;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

   

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionTransactionBankAccount[ id=" + id + " ]";
    }
    
}
