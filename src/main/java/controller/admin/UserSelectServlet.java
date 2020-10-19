package controller.admin;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 根据uiserid 或者无条件查询用户表
 */
@WebServlet(name = "UserSelectServlet",urlPatterns = "/userSelectServlet")
public class UserSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //接收参数
        String userId=req.getParameter("userid");
        //将这个参数传给UserDao 的userSelect(String userid)
        UserDao userDao=new UserDao();
        try {
            List<User> list = userDao.userSelect(userId);
            System.out.println(list.toString());
            //将数据绑定到userlist.jsp页面
            req.setAttribute("list",list);
            req.getRequestDispatcher("/resources/admin/userlist.jsp").forward(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
