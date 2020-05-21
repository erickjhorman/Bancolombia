
package col.com.er.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncriptarPassword {

    public static void main(String[] args) {

       
        String password = "123";
        System.out.print("password" + password);
        System.out.print("password encriptado" + encriptarPassword(password));
    }

    public static String encriptarPassword(String password){
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
            
}