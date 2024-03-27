package com.devpro.android54_day4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devpro.android54_day4.adapters.PostAdapter;
import com.devpro.android54_day4.models.Post;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView rvPost;
    private PostAdapter mPostAdapter;
    private ArrayList<Post> mListPost;

    public MainActivity3() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler_view);
        initData();
        initView();
    }

    private void initData() {
        mListPost = new ArrayList<>();
        for (int i=0; i< 10; i++){
            Post post = new Post();
            post.setId(i);
            post.setUserName("US "+i);
            post.setAvatar("https://vietnamnet.vn/bi-kip-san-anh-dep-o-bien-vo-cuc-thai-binh-dang-hot-ran-ran-2055578.html");
            post.setTime(""+i+" h");
            post.setStatus("status "+i);
            mListPost.add(post);
        }
    }

    private void initView() {
        rvPost = findViewById(R.id.rvPost);
        mPostAdapter = new PostAdapter(mListPost);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        rvPost.setLayoutManager(layoutManager);
        rvPost.setAdapter(mPostAdapter);

        mPostAdapter.setCallback(clickListener);

    }

    private PostAdapter.IPostItemClickListener clickListener = new PostAdapter.IPostItemClickListener() {
        @Override
        public void onDeletePost(int pos) {
            mListPost.remove(pos);
//            mPostAdapter.notifyDataSetChanged();

            mPostAdapter.notifyItemRemoved(pos);
        }

        @Override
        public void onUpdateReaction(int pos) {
            Post post = mListPost.get(pos);
            post.setLike(!post.isLike());

            mListPost.set(pos, post);
            mPostAdapter.notifyItemChanged(pos);
        }
    };
}