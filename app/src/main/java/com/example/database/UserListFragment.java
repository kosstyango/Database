package com.example.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListFragment extends Fragment {
    private RecyclerView userRecyclerView;
    private UserAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user_list, viewGroup, false);
        userRecyclerView = view.findViewById(R.id.userRecyclerView);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UserList userList = UserList.get(); //получаем список 100 пользователей
        List<User> users = userList.getUsers(); //список 100 пользователей сохраняем в users
        userAdapter = new UserAdapter(users); //передаём список users в userAdapter
        userRecyclerView.setAdapter(userAdapter); //передаём userAdapter в RecyclerView

        return view;
    }
    private class UserHolder extends RecyclerView.ViewHolder{
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup){
            super (inflater.inflate(R.layout.list_item_user, viewGroup, false));
        }
    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        private List<User> users;
        public UserAdapter(List<User> users){
            this.users = users;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder holder, int i) {

        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}
