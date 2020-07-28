package col.com.er.entity;

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
@Table(name = "users")
@XmlRootElement

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TermsAndConditions")
    private String termsAndConditions;

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    private String identification;

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 500)
    @NotNull()
    private String image;

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    @Column(name = "RegistedPhase")
    private String registedPhase;

    @Basic(optional = false)
    @NotNull
    @Column(name = "RegisterdPC")
    private String registerdPC;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    private String password;
    @Basic(optional = false)

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<UserRoles> userRoles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Client> clientList;

    public Users() {
    }

    public Users(Long id) {
        this.id = id;
    }

    public Users(Long id, String termsAndConditions, String identification, String image, String registedPhase, String registerdPC, String username, String password, Date createdAt, Date updateAt) {
        this.id = id;
        this.termsAndConditions = termsAndConditions;
        this.identification = identification;
        this.image = image;
        this.registedPhase = registedPhase;
        this.registerdPC = registerdPC;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Users[ id=" + id + " ]";
    }

}
