package com.devpro.android54_day4.models;

public class Post {
    
    private int id;
    private String userName, avatar, time,status, imgStatus;
    private int countReaction;
    private boolean isLike;

    public Post() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(String imgStatus) {
        this.imgStatus = imgStatus;
    }

    public int getCountReaction() {
        return countReaction;
    }

    public void setCountReaction(int countReaction) {
        this.countReaction = countReaction;
    }


    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", imgStatus='" + imgStatus + '\'' +
                ", countReaction=" + countReaction +
                '}';
    }
}
