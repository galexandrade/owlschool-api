package me.owlschool.security.controller;

import me.owlschool.security.transfer.AuthDTO;
import me.owlschool.security.util.JwtToken;
import me.owlschool.model.User;
import me.owlschool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Authentication(UserRepository users) {
        this.users = users;
    }

    @PostMapping(value = "/api/v1/public/auth")
    public ResponseEntity<?> auth(@RequestBody AuthDTO credentials) {

        /*TO DO: Verify user credentials here!*/
        User user = users.findByEmail(credentials.getEmail());

        if (user == null || !User.PASSWORD_ENCODER.matches(credentials.getPassword(), user.getPassword()))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        JwtToken jwtToken = new JwtToken(users);

        return ResponseEntity.ok(jwtToken.generateToken(user));

    }
}
