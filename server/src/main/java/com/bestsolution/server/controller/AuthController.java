package com.bestsolution.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public ResponseEntity signIn(@RequestParam String userName, @RequestParam String password) {

        HashMap<String, String> res = new HashMap<>();
        res.put("user_name", userName);
        res.put("password", password);

        return ResponseEntity.ok(res);
    }

}
