package com.example.lab6.daos;
import com.example.lab6.beans.Actor;

import java.sql.*;
import java.util.ArrayList;
public class ActorDAO {
    public String obtenerTituloPelicula(int idPelicula){
        String tituloPelicula = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String queryTitulo = "SELECT titulo FROM Pelicula WHERE idPelicula = ?";

        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://localhost:3306/mydb";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmtTitulo = conn.prepareStatement(queryTitulo);
            pstmtTitulo.setInt(1, idPelicula);
            ResultSet rsTitulo = pstmtTitulo.executeQuery();
            if (rsTitulo.next()) {
                tituloPelicula = rsTitulo.getString("titulo");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tituloPelicula;
    }
    public ArrayList<Actor> obtenerActoresPorPelicula(int idPelicula) {
        ArrayList<Actor> actores = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String queryActores = "SELECT a.idActor, a.nombre, a.apellido, a.anoNacimiento, a.premioOscar " +
                "FROM Actor a, Protagonistas p " +
                "WHERE a.idActor = p.idActor AND p.idPelicula = ?";

        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://localhost:3306/mydb";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(queryActores);
            pstmt.setInt(1, idPelicula);
            ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setIdActor(rs.getInt("idActor"));
                    actor.setNombre(rs.getString("nombre"));
                    actor.setApellido(rs.getString("apellido"));
                    actor.setAnoNacimiento(rs.getInt("anoNacimiento"));
                    actor.setPremioOscar(rs.getBoolean("premioOscar"));
                    actores.add(actor);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }

        return actores;
    }
}
