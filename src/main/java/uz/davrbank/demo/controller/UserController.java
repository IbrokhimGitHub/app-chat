package uz.davrbank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.davrbank.demo.payload.ResultDto;
import uz.davrbank.demo.payload.UserDto;
import uz.davrbank.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public HttpEntity<?> newUser(@RequestBody UserDto userDto){
        ResultDto resultDto =userService.newUser(userDto);
        return ResponseEntity.status(resultDto.isSuccess()?200:406).body(resultDto);
    }
}
