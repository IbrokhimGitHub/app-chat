package uz.davrbank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.davrbank.demo.payload.MessageDto;
import uz.davrbank.demo.payload.ResultDto;
import uz.davrbank.demo.service.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("send")
    public HttpEntity<?> sendMessage(@RequestBody MessageDto messageDto){
        ResultDto resultDto = messageService.sendMessage(messageDto);
        return ResponseEntity.status(resultDto.isSuccess()?200:404).body(resultDto);
    }
    @PostMapping("getChatMessages")
    public HttpEntity<?> getChatMessages(@RequestParam String chatName){
        ResultDto resultDto = messageService.getChatMessages(chatName);
        return ResponseEntity.status(resultDto.isSuccess()?200:404).body(resultDto);
    }


}
