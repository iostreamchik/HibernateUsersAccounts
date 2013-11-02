package logic;


import dao.PassDAO;
import dao.UserDataDAO;
import hibernate.classes.Pass;
import hibernate.classes.UserData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login"),
                pass = req.getParameter("pass");

        String resultLogin, resultPass;

        //Get a userData login and reference to password
        UserDataDAO userDataDAO = new UserDataDAO();
        UserData userData = null;
        try {
            userData = userDataDAO.retrieve(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Get userData password from userData reference
        PassDAO passDAO = new PassDAO();
        Pass password = null;
        try {
            assert userData != null;
            password = passDAO.retrieve(userData.getPass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (login.equals(userData.getLogin()) && pass.equals(password.getUpass())) {
            req.setAttribute("userStatus", userData.getUstatus());
            PrintWriter writer = resp.getWriter();
            if (userData.getUstatus() == 3) {
                writer.write("Welcome ROOT");
            }
            if (userData.getUstatus() == 2) {
                writer.write("Welcome ADMIN");
            }
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write("you must be authorized");
        }
    }
}


