
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
@Table(name = "description_loan_client")
@XmlRootElement

public class DescriptionLoanClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "loan_number")
    private String loanNumber;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "payments_number")
    private String paymentsNumber;
    
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
    
    @JoinColumn(name = "cState_product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    
    private CstateProduct cStateproductid;
    @JoinColumn(name = "client_products", referencedColumnName = "id")
    @ManyToOne(optional = false)
    
    private ClientProducts clientProducts;

    public DescriptionLoanClient() {
    }

    public DescriptionLoanClient(Integer id) {
        this.id = id;
    }

    public DescriptionLoanClient(Integer id, String loanNumber, String paymentsNumber, int amount, Date createdAt, Date updateAt) {
        this.id = id;
        this.loanNumber = loanNumber;
        this.paymentsNumber = paymentsNumber;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

   

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionLoanClient[ id=" + id + " ]";
    }
    
}
