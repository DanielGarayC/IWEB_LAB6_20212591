<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page import="com.example.lab6.beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) request.getAttribute("listapelis");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Películas</title>
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
<h1>Lista de peliculas</h1>

<form method="get" action="/PeliculaServlet">
    <input type="text" name="search" placeholder="Buscar película...">
    <input type="submit" value="Buscar">
</form>

<%
    if (listaPeliculas == null || listaPeliculas.isEmpty()) {
%>
<p>No se registró ninguna película para mostrar información :(;</p>
<%
} else {
%>
<table>
    <thead>
    <tr>
        <th>Título</th>
        <th>Director</th>
        <th>Ano Publicación</th>
        <th>Rating</th>
        <th>Box Office</th>
        <th>Genero</th>
        <th>Actores</th>
    </tr>
    </thead>
    <tbody>
    <%
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        for (Pelicula pelicula : listaPeliculas) {
            String formatoBoxOffice = formatter.format(pelicula.getBoxOffice());
    %>
    <tr>
        <td><a href="DetallesServlet?id=<%=pelicula.getID()%>"><%=pelicula.getTitulo()%></a></td>
        <td><%=pelicula.getDirector()%></td>
        <td><%=pelicula.getAnoPublicacion()%></td>
        <td><%=pelicula.getRating()%>/10</td>
        <td>$<%=formatoBoxOffice%></td>
        <td><%=pelicula.getGenero()%></td>
        <td><a href="ActorServlet?idPelicula=<%=pelicula.getID()%>">Ver Actores</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>

</body>
</html>