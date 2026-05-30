package com.example.taskmate.util;

import com.example.taskmate.model.User;
import com.example.taskmate.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class Authentication {

    private final UserRepository userRepository = new UserRepository();

    public boolean login(String username, String password) throws SQLException {
        User user = userRepository.findUser(username);

        if(user == null){
            return false;
        }

        return BCrypt.checkpw(password, user.getPasswordHash());
    }

    public boolean register(String username, String password){
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        System.out.println(hash);

        return userRepository.createUser(username, hash);
    }
}
