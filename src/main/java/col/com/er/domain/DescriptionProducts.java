
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "description_products")
@XmlRootElement

public class DescriptionProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "payments_time")
    private int paymentsTime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "handling_fee")
    private short handlingFee;
    
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
    
    @JoinColumn(name = "csub_products_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CsubProducts csubProductsId;

    public DescriptionProducts() {
    }

    public DescriptionProducts(Integer id) {
        this.id = id;
    }

    public DescriptionProducts(Integer id, int paymentsTime, short handlingFee, Date createdAt, Date updateAt) {
        this.id = id;
        this.paymentsTime = paymentsTime;
        this.handlingFee = handlingFee;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

   

    @Override
    public String toString() {
        return "col.com.er.domain.DescriptionProducts[ id=" + id + " ]";
    }
    
}
