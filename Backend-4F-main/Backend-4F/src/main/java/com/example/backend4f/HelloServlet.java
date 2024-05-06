package com.example.backend4f;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    @Override
    public void init(){}

    @Override
    public void destroy(){}


    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        System.out.println(request.getHeader("user-agent"));
        String username= request.getParameter("username");
        String password= request.getParameter("password");

        if ( username.equals("gino")&& password.equals("pasquale")){

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<hrml><body><h1><ciao></h1></body></html>");
        }else {
            HttpSession session = request.getSession(true);
            String message = "Login Sbagliato";
            session.setAttribute("error", message);
            response.sendRedirect("/errore");
        }

    }

}