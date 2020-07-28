
package col.com.er.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "cregistered_account")
@XmlRootElement

public class CregisteredAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "account_number")
    private String accountNumber;
    
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
    
    @JoinColumn(name = "Client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    
    private Client clientid;
    @OneToMany(mappedBy = "clientRegisteredId")
    private List<TransactionCliente> transactionClienteList;

    public CregisteredAccount() {
    }

    public CregisteredAccount(Integer id) {
        this.id = id;
    }

    public CregisteredAccount(Integer id, String name, String accountNumber, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.CregisteredAccount[ id=" + id + " ]";
    }
    
}
