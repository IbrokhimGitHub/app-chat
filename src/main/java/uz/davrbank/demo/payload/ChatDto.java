package uz.davrbank.demo.payload;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.davrbank.demo.entity.User;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatDto {

    @NotNull
    private String name;


    private List<String> usernameList;


    private User author;
}
