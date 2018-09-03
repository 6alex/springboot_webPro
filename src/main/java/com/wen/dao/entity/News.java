package com.wen.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-30
 */
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 信息id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 微信公众号
     */
    private String account;
    /**
     * 内容
     */
    private String content;
    /**
     * 图片链接
     */
    private String image;
    /**
     * 喜欢
     */
    private Integer likeCount;
    /**
     * 评论
     */
    private Integer commentCount;
    /**
     * 创建时间
     */
    private Date createdDate;
    /**
     * 用户id
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "News{" +
        "id=" + id +
        ", title=" + title +
        ", account=" + account +
        ", content=" + content +
        ", image=" + image +
        ", likeCount=" + likeCount +
        ", commentCount=" + commentCount +
        ", createdDate=" + createdDate +
        ", userId=" + userId +
        "}";
    }
}
