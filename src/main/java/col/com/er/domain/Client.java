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
@Table(name = "client")

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
    private Users users;
    
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

    @Override
    public String toString() {
        return "col.com.er.domain.Client[ id=" + id + " ]";
    }

}
