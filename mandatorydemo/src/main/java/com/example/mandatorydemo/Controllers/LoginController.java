package com.example.mandatorydemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/secret")
    public String secret(HttpSession session) {
        try {
            Object v = session.getAttribute("logged_in");
            if (v instanceof Boolean && (Boolean) v) {
                return "secret";
            } else {
                return "noaccess";
            }
        } catch (Exception ee) {
            return "noaccess";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        try {
            session.removeAttribute("logged_in");
            return "login";
        } catch (Exception ee) {
            // dummy
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, WebRequest wr) {
        String user = wr.getParameter("user");
        String pass = wr.getParameter("pass");
        if (user.equals("admin") && pass.equals("123")) {
            session.setAttribute("logged_in", true);
            return "login";
        }

        return "login";
    }


}
