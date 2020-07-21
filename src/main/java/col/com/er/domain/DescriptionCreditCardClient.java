
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
@Table(name = "description_credit_card_client")
@XmlRootElement

public class DescriptionCreditCardClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "card_number")
    private String cardNumber;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "secrity_code")
    private String secrityCode;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest_rate")
    private double interestRate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "handling_fee")
    private int handlingFee;
    
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
    
    @JoinColumn(name = "type_card_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeCard typeCardId;

    public DescriptionCreditCardClient() {
    }

    public DescriptionCreditCardClient(Integer id) {
        this.id = id;
    }

    public DescriptionCreditCardClient(Integer id, String cardNumber, String secrityCode, Date expirationDate, String name, int amount, double interestRate, int handlingFee, Date createdAt, Date updateAt) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.secrityCode = secrityCode;
        this.expirationDate = expirationDate;
        this.name = name;
        this.amount = amount;
        this.interestRate = interestRate;
        this.handlingFee = handlingFee;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

   

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionCreditCardClient[ id=" + id + " ]";
    }
    
}
