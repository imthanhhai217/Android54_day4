package com.devpro.android54_day4.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devpro.android54_day4.R;
import com.devpro.android54_day4.interfaces.IOnUserItemClickListener;
import com.devpro.android54_day4.models.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    private static final String TAG = "UserAdapter";
    private ArrayList<User> mListUser;
    private IOnUserItemClickListener callback;

    public UserAdapter(ArrayList<User> listUser, IOnUserItemClickListener callback) {
        this.mListUser = listUser;
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return mListUser.size();
    }

    @Override
    public Object getItem(int position) {
        return mListUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        } else {
            view = convertView;
        }
        Log.d(TAG, "getView: "+position);

        User user = (User) getItem(position);
        ImageView imgAvatar = view.findViewById(R.id.imgAvatar);
        TextView tvUserName = view.findViewById(R.id.tvUserName);
        TextView tvAddress = view.findViewById(R.id.tvAddress);

        tvUserName.setText(user.getUserName());
        tvAddress.setText(user.getAddress());
        Glide.with(parent.getContext()).load(user.getAvatar()).into(imgAvatar);

        imgAvatar.setOnClickListener(v -> {
            if (callback != null) {
                callback.onAvatarClick(position);
            }
        });
        tvUserName.setOnClickListener(v -> {
            if (callback != null) {
                callback.onUserNameClick(position);
            }
        });
        tvAddress.setOnClickListener(v -> {
            if (callback != null) {
                callback.onAddressClick(position);
            }
        });

        return view;
    }
}
