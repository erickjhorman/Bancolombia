
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "description_transaction_others_banks")
@XmlRootElement

public class DescriptionTransactionOthersBanks implements Serializable {

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
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "additional_info")
    private String additionalInfo;
    
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
    
    @JoinColumn(name = "cBanks_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cbanks cBanksid;
    
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    @ManyToOne(optional = false)
    private TransactionCliente transactionId;

    public DescriptionTransactionOthersBanks() {
    }

    public DescriptionTransactionOthersBanks(Long id) {
        this.id = id;
    }

    public DescriptionTransactionOthersBanks(Long id, int amount, Date createdAt, Date updateAt) {
        this.id = id;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

  

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionTransactionOthersBanks[ id=" + id + " ]";
    }
    
}
