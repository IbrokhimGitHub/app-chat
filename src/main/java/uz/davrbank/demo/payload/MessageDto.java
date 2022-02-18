package uz.davrbank.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.davrbank.demo.entity.Chat;
import uz.davrbank.demo.entity.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private String authorUsername;


    private String text;


    private String chatName;
}
