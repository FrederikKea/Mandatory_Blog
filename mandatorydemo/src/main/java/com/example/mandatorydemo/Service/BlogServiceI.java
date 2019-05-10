package com.example.mandatorydemo.Service;
import com.example.mandatorydemo.Models.Blog;

import java.sql.SQLException;
import java.util.List;

public interface BlogServiceI {
    List getBlogList() throws SQLException;

    void createBlogpost(Blog blog) throws SQLException;
}
