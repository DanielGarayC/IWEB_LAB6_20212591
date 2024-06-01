package com.example.lab6.servlets;
import com.example.lab6.beans.Actor;
import com.example.lab6.daos.ActorDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.ArrayList;
import java.io.IOException;

@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class actorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        ActorDAO actorDAO = new ActorDAO();
        String tituloPelicula = actorDAO.obtenerTituloPelicula(idPelicula);
        ArrayList<Actor> actores = actorDAO.obtenerActoresPorPelicula(idPelicula);
        request.setAttribute("tituloPelicula", tituloPelicula);
        request.setAttribute("actores", actores);
        request.getRequestDispatcher("/listaActores.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
