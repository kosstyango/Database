package com.example.database;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Активность", "Метод onCreate вызван");
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,new UserListFragment(), "main_fragment").addToBackStack("main_fragment").commit();
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d("Активность", "Метод onStart вызван");
        setContentView(R.layout.activity_main);
        Fragment fragment = new UserListFragment();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment, "main_fragment").commit();
    }
    @Override
    public void onBackPressed(){
        Fragment currentFragment = fragmentManager.findFragmentByTag("main_fragment");
        if(currentFragment!=null && currentFragment.isVisible()) {
            super.onBackPressed();
        }else{
            Fragment fragment = new UserListFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment, "main_fragment").commit();
        }
    }
    public static void changeFragment(View view, User user){ //замена фрагмента
        FragmentActivity activity = (FragmentActivity) view.getContext();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = new UserFragment(); //Создаём новый фрагмент
        Bundle bundle = new Bundle(); // Создаём новый Bundle - типа, коллекция
        bundle.putSerializable("user", user); //записываем user в bundle для передачи в фрагмент
        fragment.setArguments(bundle); //кладём bundle в фрагмент
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit(); //заменяем фрагмент
    }
}
