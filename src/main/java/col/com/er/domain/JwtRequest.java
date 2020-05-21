package col.com.er.domain;

import java.io.Serializable;

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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getRegistredpc() {
        return registredpc;
    }

    public void setRegistredpc(String registredpc) {
        this.registredpc = registredpc;
    }

    public String getRegistredPhase() {
        return registredPhase;
    }

    public void setRegistredPhase(String registredPhase) {
        this.registredPhase = registredPhase;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTermsandconditions() {
        return termsandconditions;
    }

    public void setTermsandconditions(String termsandconditions) {
        this.termsandconditions = termsandconditions;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

    
    
    
}
