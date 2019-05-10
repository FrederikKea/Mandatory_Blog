package com.example.mandatorydemo.Service;

import com.example.mandatorydemo.Models.Blog;
import com.example.mandatorydemo.Repositories.blogRepository;
import com.example.mandatorydemo.Service.BlogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements BlogServiceI {

    @Autowired
    blogRepository br; //ConsultationRepo cr;

    @Override
    public List getBlogList() throws SQLException {
        ResultSet rs;
        rs=br.blogList();
        List<Blog> bList = new ArrayList<Blog>();

        while (rs.next()) {
            bList.add(new Blog(rs.getInt("bid"),
                    rs.getString("blogpost_name"),
                    rs.getString("blogpost"),
                    rs.getString("date")));
        }
        return bList;
    }

    //Ved ikke om jeg fik implementeret noget mærkeligt her ved alt enter.
    public void createBlogpost(Blog blog) throws SQLException {
        br.createBlogpost(blog.getBlogpost_name(),blog.getBlogpost(),blog.getDate());
    }




}


















/*package com.example.mandatorydemo.Service;

import com.example.mandatorydemo.Models.Blog;
import com.example.mandatorydemo.Models.blogPosts;
import com.example.mandatorydemo.Repositories.blogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class blogService {

    @Autowired
    blogRepository br;

    public blogPosts getAll() throws SQLException {

        ResultSet resultset = br.execute();

        blogPosts bp = new blogPosts();
        //List<Blog> blogsList = new ArrayList<Blog>();


        // loop through the resultset
        while (resultset.next()) {
            Blog b = new Blog();


            // populate the book
            b.setBid(resultset.getInt("bid"));
            b.setBlogPost(resultset.getString("blogPost"));
            b.setDate(resultset.getString("date"));

            bp.setBlogs(b);
        }
        return bp;

    }

}
*/

