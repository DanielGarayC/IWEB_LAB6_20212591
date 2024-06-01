package com.example.lab6.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.lab6.daos.PeliculaDAO;
import com.example.lab6.beans.Pelicula;
import java.io.IOException;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class detallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("id"));
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        Pelicula pelicula = peliculaDAO.verInfoPelicula(idPelicula);
        request.setAttribute("pelicula", pelicula);
        request.getRequestDispatcher("/viewPelicula.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
