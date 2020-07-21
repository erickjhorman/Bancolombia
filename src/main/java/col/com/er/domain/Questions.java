
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
@Table(name = "questions")
@XmlRootElement

public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "question")
    private String question;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionsId")
    private List<Answers> answersList;

    public Questions() {
    }

    public Questions(Integer id) {
        this.id = id;
    }

    public Questions(Integer id, String question, Date createdAt, Date updateAt) {
        this.id = id;
        this.question = question;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    

    @Override
    public String toString() {
        return "col.com.er.domain.Questions[ id=" + id + " ]";
    }
    
}
