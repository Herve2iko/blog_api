package com.example.crud1.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServices {
    private static List<User> UserList = new ArrayList<User>();
    private static int count = 3;
    static{
        UserList.add(new User(1,"ikori",new Date()));
        UserList.add(new User(2,"ikori",new Date()));
        UserList.add(new User(3,"ikori",new Date()));
    }

    public List<User> findAll(){
        return UserList;
    }

    public User addUser(User user){
        if(user.getId()==null){
            user.setId(++count);
        }
        UserList.add(user);

        return user;
    }

    public User findOne(int id){
        for(User user:UserList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    public User deleteUser(int id){
        for(User user:UserList){
            if(user.getId() == id){
                UserList.remove(user);
                return user;
            }
        }
        return null;
    }
}
