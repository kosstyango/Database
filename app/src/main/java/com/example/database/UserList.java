package com.example.database;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

//Синглетный класс - можно создать только один объект
public class UserList {
    private static UserList userList;
    private List users;
    public static UserList get(){
        if(userList == null) {
            userList = new UserList();
        }
        return userList;
    }
    private UserList(){
        users = new ArrayList();
        for (int i = 0; i <100 ; i++) { //Создаём список пользователей из 100 человек
            User user = new User();
            user.setName("ИМЯ "+i);
            user.setLastName("фамилия "+i);
            users.add(user);
        }

    }
    public List getUsers(){//Геттер для списка 100 пользователей
        return users;
    }

    public void updateUser(User user) { //реализуем UPDATE базы пользователей 7_12_20
        String uuidString = user.getUuid().toString();
        ContentValues values = getContentValues(user);

        database.update(UserDbSchema.UserTable.NAME, values,
                UserDbShema.UserTable.Cols.UUID+"=?",
                new String[]{uuidString}); //избегаем опасности хакерских атак
    }


}
