package me.owlschool.security.controller;

import me.owlschool.exception.AppException;
import me.owlschool.exception.InvalidUserException;
import me.owlschool.exception.NoRecordFoundException;
import me.owlschool.security.transfer.AuthDTO;
import me.owlschool.security.util.JwtToken;
import me.owlschool.model.User;
import me.owlschool.repository.UserRepository;
import me.owlschool.security.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex.andrade on 23/06/2017.
 */
@RestController
public class Authentication {

    private final UserRepository users;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    public Authentication(UserRepository users) {
        this.users = users;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/api/v1/public/auth")
    public ResponseEntity<?> auth(@RequestBody AuthDTO credentials) throws AppException {
        java.lang.String message = "Not authorized!";

        /*TO DO: Verify user credentials here!*/
        User user = users.findByEmail(credentials.getEmail());

        if (user == null || !User.PASSWORD_ENCODER.matches(credentials.getPassword(), user.getPassword()))
            throw new InvalidUserException();
            //return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        RestResponse restResponse = new RestResponse(RestResponse.STATUS_SUCCESS, jwtToken.generateToken(user));

        return ResponseEntity.ok(restResponse);

    }
}
