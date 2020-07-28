package col.com.er.entity.dto;


import java.util.ArrayList;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String password;
    private String registredpc;
    private String registredPhase;
    private String identificacion;
    private String image;
    private String termsandconditions;
    private ArrayList<QuestionAnswersDTO> listQuestions;
    private String createdat;
    private String updatedat;

}
