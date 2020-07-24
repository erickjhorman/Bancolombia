package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduserRoles")
    private Long idUsersRoles;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    // Bi-directioanl many-to-one association to users
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    // Bi-directioanl many-to-one association to rol
    @ManyToOne()
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Crol roles;

    public UserRoles() {
    }

    public UserRoles(Long idUsersRoles) {
        this.idUsersRoles = idUsersRoles;
    }

    @Override
    public String toString() {
        return "User_Roles{" + " idUsersRoles " + idUsersRoles;
    }

}
