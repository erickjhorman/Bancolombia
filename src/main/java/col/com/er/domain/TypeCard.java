
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data  // To add the methods get y set using the library of lombok
@Entity
@Table(name = "type_card")

public class TypeCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "name")
    private String name;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeCardId")
    private List<DescriptionCreditCardClient> descriptionCreditCardClientList;

    public TypeCard() {
    }

    public TypeCard(Integer id) {
        this.id = id;
    }

    public TypeCard(Integer id, String name, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.TypeCard[ id=" + id + " ]";
    }

}
