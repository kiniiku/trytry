package controller.admin;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToUpdateUserInfoServlet",urlPatterns = "/userUpdateServlet")
public class ToUpdateUserInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userid = req.getParameter("userid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user=new User();
        user.setId(Integer.parseInt(userid));
        user.setUserName(username);
        user.setUserPassword(password);
    }
}
