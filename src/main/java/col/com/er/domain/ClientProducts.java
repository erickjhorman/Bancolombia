package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

@Data  // To add the methods get y set using the library of lombok
@Entity
@Table(name = "client_products")
@XmlRootElement

public class ClientProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientProducts")
    private List<DescriptionLoanClient> descriptionLoanClientList;
    
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client clientId;
    
    @JoinColumn(name = "sub_products_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CsubProducts subProductsId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientProducts")
    private List<DescriptionCreditCardClient> descriptionCreditCardClientList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientProducts")
    private List<DescriptionAccountClient> descriptionAccountClientList;

    public ClientProducts() {
    }

    public ClientProducts(Integer id) {
        this.id = id;
    }

    public ClientProducts(Integer id, Date createdAt, Date updateAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }


    @Override
    public String toString() {
        return "col.com.er.domain.ClientProducts[ id=" + id + " ]";
    }
    
}
