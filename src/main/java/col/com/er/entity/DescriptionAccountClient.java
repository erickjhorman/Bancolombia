
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
@Table(name = "description_account_client")
@XmlRootElement

public class DescriptionAccountClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
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
    
    @JoinColumn(name = "cState_product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CstateProduct cStateproductid;
    
    @JoinColumn(name = "client_products", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientProducts clientProducts;

    public DescriptionAccountClient() {
    }

    public DescriptionAccountClient(Integer id) {
        this.id = id;
    }

    public DescriptionAccountClient(Integer id, String accountNumber, Date createdAt, Date updateAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionAccountClient[ id=" + id + " ]";
    }
    
}
