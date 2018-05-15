<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("user");
            if (username == null) {
                 %>
                 <h1>No hay usuario validado</h1>
                 <%
                }else{
                    %>
                    <h1>Hola Jugador <%=username%></h1>
                    
                    <form action="modificacionPerfil.jsp">
                        <input type="submit" value="Modificar Perfil" name="modificarPerfilPlayers">
                    </form>
                <% }
    %>
    </body>
</html>
