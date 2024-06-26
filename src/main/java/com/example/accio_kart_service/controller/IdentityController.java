package com.example.accio_kart_service.controller;

import com.example.accio_kart_service.model.Identity;
import com.example.accio_kart_service.service.IdentityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    public final IdentityService identityService;

    public IdentityController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @PostMapping("/add")
    public String addIdentity(@RequestBody Identity identity,
                              @RequestParam("email") String email){
        identityService.addIdentity(identity,email);
        return "Identity added";
    }

}
