package com.doit.wheels.controllers;

import com.doit.wheels.dao.entities.User;
import com.doit.wheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController extends AbstractController{

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> verifyLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userService.findUserByUsername(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = "logout")
    @ResponseBody
    public ResponseEntity logout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            SecurityContextHolder.clearContext();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
