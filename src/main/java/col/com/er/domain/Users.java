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
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByCreatedAt", query = "SELECT u FROM Users u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "Users.findByUpdateAt", query = "SELECT u FROM Users u WHERE u.updateAt = :updateAt")})
public class Users implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TermsAndConditions")
    private short termsAndConditions;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    @Column(name = "identification")
    private String identification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RegistedPhase")
    private String registedPhase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegisterdPC")
    private short registerdPC;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Crol> crolList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private List<Client> clientList;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, short termsAndConditions, String identification, String image, String registedPhase, short registerdPC, String email, String password, Date createdAt, Date updateAt) {
        this.id = id;
        this.termsAndConditions = termsAndConditions;
        this.identification = identification;
        this.image = image;
        this.registedPhase = registedPhase;
        this.registerdPC = registerdPC;
        this.email = email;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Users[ id=" + id + " ]";
    }

    public short getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(short termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegistedPhase() {
        return registedPhase;
    }

    public void setRegistedPhase(String registedPhase) {
        this.registedPhase = registedPhase;
    }

    public short getRegisterdPC() {
        return registerdPC;
    }

    public void setRegisterdPC(short registerdPC) {
        this.registerdPC = registerdPC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @XmlTransient
    public List<Crol> getCrolList() {
        return crolList;
    }

    public void setCrolList(List<Crol> crolList) {
        this.crolList = crolList;
    }

}
