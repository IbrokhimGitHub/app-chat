package uz.davrbank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.davrbank.demo.entity.Chat;
import uz.davrbank.demo.entity.Message;
import uz.davrbank.demo.entity.User;
import uz.davrbank.demo.payload.MessageDto;
import uz.davrbank.demo.payload.ResultDto;
import uz.davrbank.demo.repository.ChatRepository;
import uz.davrbank.demo.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserService userService;

    @Autowired
    ChatService chatService;

    @Autowired
    MessageRepository messageRepository;

    public ResultDto sendMessage(MessageDto messageDto){
        Message message=new Message();
        message.setText(messageDto.getText());

        User author = userService.loadUserByUsername(messageDto.getAuthorUsername());
        if (author==null){
            return new ResultDto("Such author (user) didn't find",false);
        }
        Chat chat = chatService.loadChatByName(messageDto.getChatName());
        if (chat==null)
            return new ResultDto("Such chat didn't find",false);

        message.setChat(chat);
        message.setAuthor(author);
        messageRepository.save(message);
        return new ResultDto("Message sent",true);



    }

    public ResultDto getChatMessages(String chatName){
        Chat chat = chatService.loadChatByName(chatName);
        if (chat==null)
            return new ResultDto("Such chat didn't find",false);
        List<Message> messagesByChat = messageRepository.findAllByChat(chat);

        return new ResultDto("Here chat's messages",true,messagesByChat);

    }
}
