package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet("/log")
public class Login extends HttpServlet {

    private final String userValid = "admin";
    private final String passwordValid = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Optional<Cookie> cookie = Arrays.stream(cookies)
                    .filter(w -> "isLogged".equals(w.getName()))
                    .findFirst();

            if (cookie.isPresent()) {
                RequestDispatcher dispatcher =
                        req.getRequestDispatcher("panelLog.jsp");
                dispatcher.forward(req, resp);
            }
            else {
                RequestDispatcher dispatcher =
                        req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String password = req.getParameter("password");

        if (user.equals(userValid) && password.equals(passwordValid)){
            Cookie cookie = new Cookie("isLogged", user);
            cookie.setMaxAge(30*60);
            resp.addCookie(cookie);
            resp.sendRedirect("/panelLog.jsp");
        }else{
            resp.sendRedirect("/login.jsp");
        }
    }
}