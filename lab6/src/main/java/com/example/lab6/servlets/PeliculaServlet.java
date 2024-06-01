package com.example.lab6.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab6.beans.Pelicula;
import com.example.lab6.daos.PeliculaDAO;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet Pelis", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> listaPeliculas = peliculaDAO.obtenerPeliculas();
        String search = request.getParameter("search");

        if (search != null && !search.trim().isEmpty()) {
            listaPeliculas = peliculaDAO.buscarPeliculas(search);
        } else {
            listaPeliculas = peliculaDAO.obtenerPeliculas();
        }

        request.setAttribute("listapelis",listaPeliculas);
        request.getRequestDispatcher("listaPeliculas.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}