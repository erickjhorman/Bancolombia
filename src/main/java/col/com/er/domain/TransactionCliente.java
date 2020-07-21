package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction_cliente")
@XmlRootElement

public class TransactionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

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
    private List<DescriptionTransactionOthersBanks> descriptionTransactionOthersBanksList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionid")
    private List<TransactionHistory> transactionHistoryList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transcationId")
    private List<DescriptionTransactionBankAccount> descriptionTransactionBankAccountList;

    @JoinColumn(name = "cState_transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateTransaction cStatetransactionid;

    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client clientId;

    @JoinColumn(name = "client1_id", referencedColumnName = "id")
    @ManyToOne
    private Client client1Id;

    @JoinColumn(name = "client_registered_id", referencedColumnName = "id")
    @ManyToOne
    private CregisteredAccount clientRegisteredId;

    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;

    public TransactionCliente() {
    }

    public TransactionCliente(Long id) {
        this.id = id;
    }

    public TransactionCliente(Long id, Date createdAt, Date updateAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.TransactionCliente[ id=" + id + " ]";
    }

}
