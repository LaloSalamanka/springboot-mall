package com.lalochen.springbootmall.controller;

import com.lalochen.springbootmall.dto.LoginResponse;
import com.lalochen.springbootmall.dto.UserLoginRequest;
import com.lalochen.springbootmall.dto.UserRegisterRequest;
import com.lalochen.springbootmall.model.User;
import com.lalochen.springbootmall.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000/"})
@Tag(name = "User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponse> login(HttpServletRequest request, @RequestBody @Valid UserLoginRequest userLoginRequest) {
        User user = userService.login(userLoginRequest);

        // 包裝登入狀態和使用者資訊
        LoginResponse response = new LoginResponse(true, user);
        System.out.println(response);

        // 返回自訂的 DTO
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
