package uz.davrbank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.davrbank.demo.entity.Chat;
import uz.davrbank.demo.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface ChatRepository extends JpaRepository<Chat,Integer> {
    boolean existsByName(String name);

    Optional<Chat> findByName(String name);

//    List<Chat> findAllByUsers(List<User> users);

    @Query(value = "select  * from  chat join chat_users cu on chat.id = cu.chat_id\n" +
            "where cu.users_id =:userId",nativeQuery = true)
    List<Chat> findAllByUserId(Integer userId);


}
