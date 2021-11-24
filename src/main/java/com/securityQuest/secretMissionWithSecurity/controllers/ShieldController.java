package com.securityQuest.secretMissionWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShieldController {

    @GetMapping("/")
    public String index() {
        return "Welcome to SHIELD.";
    }

    @GetMapping("avengers/assemble")
    public String heroes(){
        return "Avengers..... Assemble";
    }

    @GetMapping("/secret-bases")
    public String director(){
        return "Amsterdam, Barcelona, Berlin, Brussels, Bucharest, Lisbon, Lonodon, Madrid and all cities in France";
    }
}
