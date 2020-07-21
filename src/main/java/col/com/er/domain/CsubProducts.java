
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "csub_products")


public class CsubProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "products_id")
    private int productsId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "sub_product")
    private String subProduct;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subProductsId")
    private List<ClientProducts> clientProductsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "csubProductsId")
    private List<DescriptionProducts> descriptionProductsList;

    public CsubProducts() {
    }

    public CsubProducts(Integer id) {
        this.id = id;
    }

    public CsubProducts(Integer id, int productsId, String subProduct, Date createdAt, Date updateAt) {
        this.id = id;
        this.productsId = productsId;
        this.subProduct = subProduct;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.CsubProducts[ id=" + id + " ]";
    }
    
}
