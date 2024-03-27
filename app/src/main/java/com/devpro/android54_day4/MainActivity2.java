package com.devpro.android54_day4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devpro.android54_day4.adapters.UserAdapter;
import com.devpro.android54_day4.interfaces.IOnUserItemClickListener;
import com.devpro.android54_day4.models.User;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements IOnUserItemClickListener {

    private ListView lvDemo;
    private ArrayList<String> mColor;
    private ArrayList<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvDemo = findViewById(R.id.lvDemo);

        mColor = new ArrayList<>();
        mColor.add("Xanh");
        mColor.add("Do");
        mColor.add("Tim");
        mColor.add("Vang");
        mColor.add("Luc");
        mColor.add("Lam");

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,mColor);
//        lvDemo.setAdapter(arrayAdapter);

        mListUser = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("User " + i);
            user.setAddress("HN " + i);
            user.setAvatar(MainActivity.URL);
            mListUser.add(user);
        }


        UserAdapter userAdapter = new UserAdapter(mListUser, this);
        lvDemo.setAdapter(userAdapter);

        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, "Hello " + mListUser.get(position).getUserName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onAvatarClick(int position) {

    }

    @Override
    public void onUserNameClick(int position) {
        Toast.makeText(this, "Click user name "+mListUser.get(position).getUserName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddressClick(int position) {
        Toast.makeText(this, "Click address "+mListUser.get(position).getAddress(), Toast.LENGTH_SHORT).show();
    }
}