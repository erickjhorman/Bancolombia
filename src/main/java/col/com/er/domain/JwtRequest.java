package col.com.er.domain;

import java.io.Serializable;
import lombok.Data;

@Data
/*
This class is required for storing the username and password we recieve from the client.
 */
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
    private String registredpc;
    private String registredPhase;
    private String identificacion;
    private String image;
    private String termsandconditions;
    private String createdat;
    private String updatedat;

    //need default constructor for JSON Parsing
    public JwtRequest() {
    }

    /*
    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
     */
    public JwtRequest(String username, String password, String registredpc, String registredPhase, String identificacion, String image, String termsandconditions, String createdat, String updatedat) {
        this.username = username;
        this.password = password;
        this.registredpc = registredpc;
        this.registredPhase = registredPhase;
        this.identificacion = identificacion;
        this.image = image;
        this.termsandconditions = termsandconditions;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    
}
