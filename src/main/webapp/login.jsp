<html>
<head>
    <meta charset="UTF-8">
    <title>Login - My Construccion</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <form action="auth" method="post">
        <label>Usuario:</label><br>
        <input type="text" name="username" required><br><br>

        <label>Contraseña:</label><br>
        <input type="password" name="password" required><br><br>

        <button type="submit">Ingresar</button>

        <%-- Mostrar errores --%>
        <p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
    </form>
</body>
</html>