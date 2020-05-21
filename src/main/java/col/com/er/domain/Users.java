/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Data
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByTermsAndConditions", query = "SELECT u FROM Users u WHERE u.termsAndConditions = :termsAndConditions"),
    @NamedQuery(name = "Users.findByIdentification", query = "SELECT u FROM Users u WHERE u.identification = :identification"),
    @NamedQuery(name = "Users.findByImage", query = "SELECT u FROM Users u WHERE u.image = :image"),
    @NamedQuery(name = "Users.findByRegistedPhase", query = "SELECT u FROM Users u WHERE u.registedPhase = :registedPhase"),
    @NamedQuery(name = "Users.findByRegisterdPC", query = "SELECT u FROM Users u WHERE u.registerdPC = :registerdPC"),
    @NamedQuery(name = "Users.finByUserName", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByCreatedAt", query = "SELECT u FROM Users u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "Users.findByUpdateAt", query = "SELECT u FROM Users u WHERE u.updateAt = :updateAt")})

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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
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

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
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
