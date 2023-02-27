package com.example.jakartaee.servlet;

import com.example.jakartaee.dto.FoodDto;
import com.example.jakartaee.entity.Food;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    
    private String message;

    @Inject
    private Client client;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FoodDto customer = client.target("http://localhost:8080/api/foods")
                .request("application/json")
                .get(FoodDto.class);

        response.setContentType("text/html");

        String value = request.getParameter("q");

        String header = request.getHeader("host");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<div>" + value + "</div>");
        out.println("<div>" + customer.getName() + "</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
