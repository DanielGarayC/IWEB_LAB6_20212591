package com.example.lab6.daos;

import com.example.lab6.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDAO {

    public ArrayList<Pelicula> obtenerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, " +
                "(SELECT nombre FROM Genero WHERE idGenero = p.idGenero) AS genero " +
                "FROM Pelicula p " +
                "ORDER BY p.rating DESC, p.boxOffice DESC";

        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://localhost:3306/mydb";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setID(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                pelicula.setGenero(rs.getString("genero"));

                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public ArrayList<Pelicula> buscarPeliculas(String titulo) {
        ArrayList<Pelicula> listaBusqueda = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice," +
                "(SELECT nombre FROM Genero WHERE idGenero = p.idGenero) AS genero " +
        "FROM Pelicula p " +
        "WHERE p.titulo LIKE ? " +
        "ORDER BY p.rating DESC, p.boxOffice DESC";

        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://localhost:3306/mydb";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setID(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                pelicula.setGenero(rs.getString("genero"));

                listaBusqueda.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaBusqueda;
    }

    public Pelicula verInfoPelicula(int id) {
        Pelicula pelicula = new Pelicula();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice," +
                "(SELECT nombre FROM genero WHERE idGenero = p.idGenero) AS genero " +
        "FROM pelicula p " +
        "WHERE p.idPelicula = ?";


        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://localhost:3306/mydb";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = null;;
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pelicula.setID(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                pelicula.setGenero(rs.getString("genero"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelicula;
    }
}