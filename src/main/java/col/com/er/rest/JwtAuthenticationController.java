package col.com.er.rest;

import col.com.er.config.JwtTokenUtil;
import col.com.er.entity.JwtRequest;
import col.com.er.entity.JwtResponse;
import col.com.er.entity.Users;
import col.com.er.entity.dto.UserDTO;
import col.com.er.rest.request.UserRequest;
import col.com.er.service.JwtUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin
@Api(value = "Bancolombia API", description = "Operations pertaining to Home")
/*To customize my api */
@RequestMapping("/api/v1")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    /*
    Expose a POST API /authenticate using the JwtAuthenticationController. 
//    The POST API gets username and password in the body- Using Spring Authentication Manager we authenticate the username and password.If the credentials are valid, 
    a JWT token is created using the JWTTokenUtil and provided to the client.
     */
    @ApiOperation(value = "To authenticate the user", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully authenticated"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)

     public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

     
    @RequestMapping(value = "/register", method = RequestMethod.POST)
       public ResponseEntity<?> saveUser(@RequestBody UserRequest  user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user.toEntity(),user.toEntityClientAnswers()));
    }
    
    
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
