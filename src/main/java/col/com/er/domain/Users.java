
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
@Entity
@Table(name = "users")
@XmlRootElement

public class Users implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TermsAndConditions")
    private String termsAndConditions;

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    @Column(name = "identification")
    private String identification;

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 500)
    @NotNull()
    @Column(name = "image")
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
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Crol> crolList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
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

    @XmlTransient
    public List<Crol> getCrolList() {
        return crolList;
    }

    public void setCrolList(List<Crol> crolList) {
        this.crolList = crolList;
    }

}
