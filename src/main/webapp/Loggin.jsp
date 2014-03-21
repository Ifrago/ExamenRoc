<%@ page session="true"  import="Servidor.*"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html><html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta content="text/html;charset=UTF-8" http-equiv="Content-Type" />
    <title>Login Page</title>
    <style>
    body {
        color:#0000;
      font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
      }
    </style>
  </head>
  <body>
    <h1>Login Page</h1>
    <form method="POST" action="/ExamenRoc/ServidorServlet"> Please enter your username
      <input type="text" name="username"/><br />
      Please enter your password <input type="text" name="password" /><br />
      <input type="submit" value="submit" /> </form>
       <input type="text" name="action" value="LOGIN">
  </body>
</html>
