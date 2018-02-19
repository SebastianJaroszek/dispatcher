package pl.dominisz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDetailsService userDetailsService;

    public LoginServlet() {
        this.userDetailsService = new UserDetailsService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");*/

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        RequestDispatcher requestDispatcher;
        if (userDetailsService.isAuthenticated(username, password)) {
            requestDispatcher = req.getRequestDispatcher("welcome");
        } else {
            requestDispatcher = req.getRequestDispatcher("loginerror.html");
        }
        req.setAttribute("servlet_name", "LoginServlet");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome!</h1>");
    }

}
