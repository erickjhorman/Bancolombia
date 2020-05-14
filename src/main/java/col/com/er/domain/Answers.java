
package col.com.er.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a"),
    @NamedQuery(name = "Answers.findById", query = "SELECT a FROM Answers a WHERE a.id = :id"),
    @NamedQuery(name = "Answers.findByAnswer", query = "SELECT a FROM Answers a WHERE a.answer = :answer"),
    @NamedQuery(name = "Answers.findByCreatedAt", query = "SELECT a FROM Answers a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "Answers.findByUpdateAt", query = "SELECT a FROM Answers a WHERE a.updateAt = :updateAt")})
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public Questions getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Questions questionsId) {
        this.questionsId = questionsId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof Answers)) {
            return false;
        }
        Answers other = (Answers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "col.com.er.domain.Answers[ id=" + id + " ]";
    }
    
}
