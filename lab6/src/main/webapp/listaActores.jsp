<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab6.beans.Actor" %>
<%@ page import="com.example.lab6.beans.Pelicula" %>
<% ArrayList<Actor> listaActores = (ArrayList<Actor>) request.getAttribute("actores"); %>
<% String pelicula = (String) request.getAttribute("tituloPelicula"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=pelicula%></title>
    <style>
        table {
            border-collapse: separate;
            border-spacing: 1px;
            border: 1px solid black;
        }
        th, td {
            border: 1px solid black;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1><%= pelicula %></h1>
<table>
    <thead>
    <tr>
        <th>idActor</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Ano Nacimiento</th>
        <th>Ganador Premio Oscar</th>
    </tr>
    </thead>
    <tbody>
    <% if (listaActores == null || listaActores.isEmpty()) { %>
    <tr>
        <td>No hay actores para esta película. (caso raro) </td>
    </tr>
    <% } else {
        for (Actor actor : listaActores) { %>
    <tr>
        <td><%= actor.getIdActor() %></td>
        <td><%= actor.getNombre() %></td>
        <td><%= actor.getApellido() %></td>
        <td><%= actor.getAnoNacimiento() %></td>
        <td><%= actor.isPremioOscar() ? "true" : "false" %></td>
    </tr>
    <% } } %>
    </tbody>
</table>
</body>
</html>