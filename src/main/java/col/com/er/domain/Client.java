/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByDeparmentId", query = "SELECT c FROM Client c WHERE c.deparmentId = :deparmentId"),
    @NamedQuery(name = "Client.findByCityId", query = "SELECT c FROM Client c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Client.findByPhoneNumber", query = "SELECT c FROM Client c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Client.findByBirthDay", query = "SELECT c FROM Client c WHERE c.birthDay = :birthDay"),
    @NamedQuery(name = "Client.findByCreatedAt", query = "SELECT c FROM Client c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Client.findByUpdateAt", query = "SELECT c FROM Client c WHERE c.updateAt = :updateAt")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deparment_id")
    private int deparmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "city_id")
    private int cityId;
    @Size(max = 15)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 15)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 15)
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "BirthDay")
    @Temporal(TemporalType.DATE)
    private Date birthDay;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<ClientProducts> clientProductsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientid")
    private List<CregisteredAccount> cregisteredAccountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Answers> answersList;
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<TransactionCliente> transactionClienteList;
    @OneToMany(mappedBy = "client1Id")
    private List<TransactionCliente> transactionClienteList1;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, int deparmentId, int cityId, Date createdAt, Date updateAt) {
        this.id = id;
        this.deparmentId = deparmentId;
        this.cityId = cityId;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDeparmentId() {
        return deparmentId;
    }

    public void setDeparmentId(int deparmentId) {
        this.deparmentId = deparmentId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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
    public List<ClientProducts> getClientProductsList() {
        return clientProductsList;
    }

    public void setClientProductsList(List<ClientProducts> clientProductsList) {
        this.clientProductsList = clientProductsList;
    }

    @XmlTransient
    public List<CregisteredAccount> getCregisteredAccountList() {
        return cregisteredAccountList;
    }

    public void setCregisteredAccountList(List<CregisteredAccount> cregisteredAccountList) {
        this.cregisteredAccountList = cregisteredAccountList;
    }

    @XmlTransient
    public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @XmlTransient
    public List<TransactionCliente> getTransactionClienteList() {
        return transactionClienteList;
    }

    public void setTransactionClienteList(List<TransactionCliente> transactionClienteList) {
        this.transactionClienteList = transactionClienteList;
    }

    @XmlTransient
    public List<TransactionCliente> getTransactionClienteList1() {
        return transactionClienteList1;
    }

    public void setTransactionClienteList1(List<TransactionCliente> transactionClienteList1) {
        this.transactionClienteList1 = transactionClienteList1;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Client[ id=" + id + " ]";
    }
    
}
