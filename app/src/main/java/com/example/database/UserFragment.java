package com.example.database;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class UserFragment extends Fragment { //наследуем класс Fragment
    private User user; // добавляем в него приватную переменную user типа User (что за тип такой?)
    private TextView name_lastName_View; //создаём текстовое поле name_lastName_View

    @Override
    public void onCreate(Bundle savedInstanceState) { //переопределяем класс onCreate
        super.onCreate(savedInstanceState); //
        user = new User();
        user.setName("Ivan");
        user.setLastName("Petrov");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        name_lastName_View = view.findViewById(R.id.name_lastName_View);
        String userName = "Имя " + user.getName() + "\nФамилия: " + user.getLastName();
        name_lastName_View.setText(userName);
        return view;
    }
}