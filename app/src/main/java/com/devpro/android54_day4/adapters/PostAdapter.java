package com.devpro.android54_day4.adapters;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devpro.android54_day4.R;
import com.devpro.android54_day4.models.Post;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private static final String TAG = "PostAdapter";
    private ArrayList<Post> mListPost;
    private Context mContext;
    private IPostItemClickListener callback;

    public PostAdapter(ArrayList<Post> listPost) {
        this.mListPost = listPost;
    }

    public void setCallback(IPostItemClickListener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(com.devpro.android54_day4.R.layout.layout_item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = mListPost.get(position);

        Log.d(TAG, "onBindViewHolder: " + position);
        Glide.with(mContext).load(post.getAvatar()).into(holder.circleImageView);

        holder.tvUserName.setText(post.getUserName());
        holder.tvTime.setText(post.getTime());
        holder.tvStatus.setText(post.getStatus());

        int likeRes = post.isLike()
                ? com.devpro.android54_day4.R.drawable.ic_liked
                : com.devpro.android54_day4.R.drawable.ic_like;
        holder.imgReaction.setBackgroundResource(likeRes);

    }

    @Override
    public int getItemCount() {
        return mListPost != null ? mListPost.size() : 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView circleImageView;
        TextView tvUserName, tvTime, tvStatus;
        ImageView imgContent, imgDelete, imgReaction;
        LinearLayout llReaction;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(com.devpro.android54_day4.R.id.circleImageView);
            tvUserName = itemView.findViewById(com.devpro.android54_day4.R.id.tvUserName);
            tvTime = itemView.findViewById(com.devpro.android54_day4.R.id.tvTime);
            tvStatus = itemView.findViewById(com.devpro.android54_day4.R.id.tvStatus);
            imgContent = itemView.findViewById(com.devpro.android54_day4.R.id.imgContent);
            imgDelete = itemView.findViewById(com.devpro.android54_day4.R.id.imgDelete);
            imgReaction = itemView.findViewById(com.devpro.android54_day4.R.id.imgReaction);
            llReaction = itemView.findViewById(com.devpro.android54_day4.R.id.llReaction);

            imgDelete.setOnClickListener(this);
            llReaction.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == com.devpro.android54_day4.R.id.imgDelete) {
                if (callback != null) {
                    callback.onDeletePost(getAdapterPosition());
                }
            }
            if (v.getId() == com.devpro.android54_day4.R.id.llReaction) {
                if (callback != null) {
                    callback.onUpdateReaction(getAdapterPosition());
                }
            }

        }
    }

    public interface IPostItemClickListener {
        void onDeletePost(int pos);

        void onUpdateReaction(int pos);
    }
}
