package uz.davrbank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import uz.davrbank.demo.entity.User;
import uz.davrbank.demo.payload.ResultDto;
import uz.davrbank.demo.payload.UserDto;
import uz.davrbank.demo.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public ResultDto newUser(UserDto userDto) {
        boolean existsByUsername = userRepository.existsByUsername(userDto.getUsername());
        if (existsByUsername)
            return new ResultDto("such username already in database",false);
        User user =new User();
        user.setUsername(userDto.getUsername());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new ResultDto("user with username: "+user.getUsername()+" is saved",true);


    }

    public User loadUserByUsername(String username){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(new User());


    }
}
