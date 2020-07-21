package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author erick
 */
@Data  // To add the methods get y set using the library of lombok
@Entity
@Table(name = "answers")
public class Answers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "answer")
    private String answer;
    
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
    
    @JoinColumn(name = "questions_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Questions questionsId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client clientId;

    public Answers() {
    }

    public Answers(Integer id) {
        this.id = id;
    }

    public Answers(Integer id, String answer, Date createdAt, Date updateAt) {
        this.id = id;
        this.answer = answer;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }


    @Override
    public String toString() {
        return "col.com.er.domain.Answers[ id=" + id + " ]";
    }

}
