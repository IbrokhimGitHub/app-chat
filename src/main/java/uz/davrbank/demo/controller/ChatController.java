package uz.davrbank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.davrbank.demo.payload.ChatDto;
import uz.davrbank.demo.payload.ResultDto;
import uz.davrbank.demo.payload.UserDto;
import uz.davrbank.demo.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    ChatService chatService;

    @PostMapping("/new")
    public HttpEntity<?> newChat(@RequestBody ChatDto chatDto){
        ResultDto resultDto = chatService.newChat(chatDto);
        return ResponseEntity.status(resultDto.isSuccess()?200:404).body(resultDto);
    }

    @GetMapping("/list")
    public HttpEntity<?> userChats(@RequestParam String username){
        ResultDto resultDto = chatService.userChats(username);
        return ResponseEntity.status(resultDto.isSuccess()?200:404).body(resultDto);
    }


}
