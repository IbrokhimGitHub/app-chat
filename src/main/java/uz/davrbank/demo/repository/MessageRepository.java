package uz.davrbank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.davrbank.demo.entity.Chat;
import uz.davrbank.demo.entity.Message;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllByChat(Chat chat);
}
