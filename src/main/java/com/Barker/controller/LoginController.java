package com.Barker.controller;

import com.Barker.dto.LoginDto;
import com.Barker.model.User;
import com.Barker.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("")
    public void login(@RequestBody User user , HttpServletResponse res) throws IOException {
        if (userService.login(user)) {
            System.out.println("Logged in successfully");
            User loggedInUser = userService.getUser(user);
            LoginDto loginDto = new LoginDto(loggedInUser.getId() , loggedInUser.getUserName());
            res.getWriter()
                    .append("Logged in successfully!\n")
                    .append(objectMapper.writeValueAsString(loginDto));
        } else {
            res.getWriter().append("Incorrect username or password.");
            res.setStatus(401);
        }
        res.setContentType("application/json");
    }
}
