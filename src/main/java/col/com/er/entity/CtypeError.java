
package col.com.er.entity;

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
@Table(name = "ctype_error")
@XmlRootElement

public class CtypeError implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcType_Error")
    private Integer idcTypeError;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
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
    
    @OneToMany(mappedBy = "cTypeErrorid")
    private List<Transaction> transactionList;

    public CtypeError() {
    }

    public CtypeError(Integer idcTypeError) {
        this.idcTypeError = idcTypeError;
    }

    public CtypeError(Integer idcTypeError, String name, Date createdAt, Date updateAt) {
        this.idcTypeError = idcTypeError;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.CtypeError[ idcTypeError=" + idcTypeError + " ]";
    }
    
}
