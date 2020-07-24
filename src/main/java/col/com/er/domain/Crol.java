
package col.com.er.domain;

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
@Table(name = "crol")
@XmlRootElement

public class Crol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private long idRol;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol")
    private String rol;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private List<UserRoles> userRoles;

    public Crol() {
    }

    public Crol(Integer idRol) {
        this.idRol = idRol;
    }

    public Crol(Integer idRol, String rol, Date createdAt, Date updateAt) {
        this.idRol = idRol;
        this.rol = rol;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.Crol[ idRol=" + idRol + " ]";
    }
    
}
