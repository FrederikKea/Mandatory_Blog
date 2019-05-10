package com.example.mandatorydemo.Controllers;

import com.example.mandatorydemo.Models.Blog;
import com.example.mandatorydemo.Service.BlogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LavblogpostController {

    @Autowired
    BlogServiceI bs;

    @GetMapping ("/Lavblogpost") //den url man skal ind på
    public String ShowBlogs (Model model) throws Exception {
        model.addAttribute("username", "Frederik");
        model.addAttribute("lavblogpost", bs.getBlogList());
        model.addAttribute("blog", new Blog());

        return "lavblogpost"; //skal være det samme som html man reffere til
    }


    @PostMapping ("/Lavblogpost")
    public String createPost (@ModelAttribute Blog blog) throws Exception {
        //bs.createBlogpost(blog);
        System.out.println(blog);
        //return "redirect:/Blogpost";
        return "lavblogpost";
    }


}

