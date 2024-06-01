<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page import="com.example.lab6.beans.Pelicula" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<% Pelicula pelicula = (Pelicula) request.getAttribute("pelicula"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%= pelicula.getTitulo() %></title>
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
<h1><%= pelicula.getTitulo() %></h1>
<table>
    <%
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        String formatoBoxOffice = formatter.format(pelicula.getBoxOffice());
    %>
    <tr>
        <th>idPelicula</th>
        <td><%= pelicula.getID() %></td>
    </tr>
    <tr>
        <th>Director</th>
        <td><%= pelicula.getDirector() %></td>
    </tr>
    <tr>
        <th>Año Publicación</th>
        <td><%= pelicula.getAnoPublicacion() %></td>
    </tr>
    <tr>
        <th>Rating</th>
        <td><%= pelicula.getRating() %>/10</td>
    </tr>
    <tr>
        <th>Box Office</th>
        <td><%=formatoBoxOffice%></td>
    </tr>
    <tr>
        <th>Genero</th>
        <td><%= pelicula.getGenero() %></td>
    </tr>
    <tr>
        <th>Actores</th>
        <td><a href="ActorServlet?idPelicula=<%= pelicula.getID() %>">Ver Actores</a></td>
    </tr>
</table>
</body>
</html>