package uz.davrbank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.davrbank.demo.entity.Chat;
import uz.davrbank.demo.entity.User;
import uz.davrbank.demo.payload.ChatDto;
import uz.davrbank.demo.payload.ResultDto;
import uz.davrbank.demo.repository.ChatRepository;

import java.util.*;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserService userService;

    public ResultDto newChat(ChatDto chatDto){
        boolean existsByName = chatRepository.existsByName(chatDto.getName());
        if (existsByName)
            return new ResultDto("such chat name already exist",false);
        Chat chat=new Chat();
        chat.setName(chatDto.getName());
        List<User> users=new ArrayList<>();
        for (String username : chatDto.getUsernameList()) {
            User user = userService.loadUserByUsername(username);
            users.add(user);
        }
        chat.setUsers(users);
        chatRepository.save(chat);
        return new ResultDto("new chat is created",true);


    }

    public Chat loadChatByName(String chatName){
        Optional<Chat> optionalChat = chatRepository.findByName(chatName);
        return optionalChat.orElse(new Chat());
    }

    public ResultDto userChats(String username){
        User user = userService.loadUserByUsername(username);
        if (user==null) {
            return new ResultDto("User with such username didn't find",false);
        }
        List<User> onlyOneUser=new ArrayList<>();
        onlyOneUser.add(user);
        List<Chat> chatsByUser = chatRepository.findAllByUserId(user.getId());
        return new ResultDto("Here "+username+" chats",true,chatsByUser);


    }





}
