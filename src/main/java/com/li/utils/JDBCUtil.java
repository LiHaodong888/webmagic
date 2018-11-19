package com.li.utils;/**
 * @author lihaodong
 * @create 2018-10-11 12:35
 * @desc
 **/

import com.li.model.ArticleVo;

import java.sql.*;

/**
 * @author lihaodong
 * @create 2018-10-11 12:35
 * @desc
 **/

public class JDBCUtil {

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); // classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    // 插入文章
    public static int insertArticle(ArticleVo article) {
        Connection conn = getConn();
        int id = 0;
        String sql = "insert into articles (userName,img,content) values(?,?,?)";
//        PreparedStatement pstmt;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, article.getContent());
            pstmt.setString(2, article.getImg());
            pstmt.setString(3, article.getContent());

            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()){
                id = keys.getInt(1);
             }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public static void main(String[] args) {
        ArticleVo articleVo = new ArticleVo();
        articleVo.setImg("1");
        articleVo.setUserName("2");
        articleVo.setContent("3");
        int i = insertArticle(articleVo);

    }

}
