package com.example.database;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class UserFragment extends Fragment { //наследуем класс Fragment
    private User user; // добавляем в него приватную переменную user типа User (что за тип такой?)
    private TextView name_lastName_View; //создаём текстовое поле name_lastName_View
    private EditText = editName;
    private EditText = editLastName;
    private Button updateBtn;
    private UserList userList;

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
        userList = UserList.get(getActivity());
        name_lastName_View = view.findViewById(R.id.name_lastName_View);
        editName = view.findViewById(R.id.editName);
        editLastName = view.findViewById(R.id.editLastName);
        updateBtn = view.findViewById(R.id.updateBtn);
        String userName = "Имя " + user.getName() + "\nФамилия: " + user.getLastName();
        name_lastName_View.setText(userName);
        updateBtn.setOnClickListener(){
            @Override
            public void onClick(View view){
                String newUserName=editName.getText().toString();
                String newUserLastName=editLastName.getText().toString();
                user.setName(newUserName);
                user.setLastName(newUserLastName);
                userList.updateUser(user);
                Toast.makeText(getActivity(), "Данные изменены", Toast.LENGTH_SHORT).show(); //всплывающее окно подтверждение
            }
        };
        return view;
    }
}