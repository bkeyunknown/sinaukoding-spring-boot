package com.mrf.sinaikoding.perpustakaan.controller;

import com.mrf.sinaikoding.perpustakaan.common.RestResult;
import com.mrf.sinaikoding.perpustakaan.entity.User;
import com.mrf.sinaikoding.perpustakaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/auth")
public class AuthenticationController extends BaseController {

    @Autowired
    private UserService service;

    @PostMapping(value = "do-login")
    public RestResult doLogin(@RequestBody User user) {
        return service.login(user);
    }

    @PostMapping(value = "do-register")
    public RestResult register(@RequestBody User param) {
        return new RestResult(service.register(param, User.Role.ROLE_USER));
    }
}
