package com.li.model;/**
 * @author lihaodong
 * @create 2018-09-27 16:35
 * @desc 内容实体类
 **/

/**

 * @author lihaodong

 * @create 2018-09-27 16:35

 * @desc 文章实体类

 **/

public class ArticleVo {

    // 主键
    private Long id;
    private String userName;
    private String img;
    // 内容
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
