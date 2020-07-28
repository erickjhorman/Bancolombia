package col.com.er.entity;

import java.io.Serializable;
import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "client_answers")
public class ClientAnswers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientes;

    @ManyToOne()
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Questions questions;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private Answers answers;

    public ClientAnswers() {
    }

    public ClientAnswers(Long id) {
        this.id = id;
    }

}
