package com.hjp.chatbot.domain.zsxq.model.vo;

/**
 * Copyright 2023 json.cn
 */
import java.util.Date;



/**
 * Auto-generated: 2023-02-28 14:36:57
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class ShowComments {

    private long comment_id;
    private Date create_time;
    private Owner owner;
    private String text;
    private int likes_count;
    private int rewards_count;
    private boolean sticky;
    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }
    public long getComment_id() {
        return comment_id;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }
    public int getLikes_count() {
        return likes_count;
    }

    public void setRewards_count(int rewards_count) {
        this.rewards_count = rewards_count;
    }
    public int getRewards_count() {
        return rewards_count;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }
    public boolean getSticky() {
        return sticky;
    }

}