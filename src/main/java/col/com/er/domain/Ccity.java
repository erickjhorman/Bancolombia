package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

@Data

/**
 *
 * @author erick
 */
@Entity
@Table(name = "ccity")
@XmlRootElement

public class Ccity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "city")
    private String city;
    
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
    
   

    public Ccity() {
    }

    public Ccity(Integer id) {
        this.id = id;
    }

    public Ccity(Integer id, String city, Date createdAt, Date updateAt) {
        this.id = id;
        this.city = city;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.Ccity[ id=" + id + " ]";
    }
    
}
