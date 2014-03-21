
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html><html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>New Message</title>
    <style>
    body {
        color:#0000;
      font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
      }
    </style>
  </head>
  <%
  String name = (String) request.getAttribute("username");
  %>
  <body>
    <h1>New Message</h1>
    <form action="/ExamenRoc/ServidorServlet" method="POST"> Please enter destination <input

        type="text" name="username" /><br />
      Please enter subject <input type="text" name="subject" /><br />
      Please enter body <textarea rows="10" cols="30" name="body"> Message </textarea>
      <input type="submit" value="submit" /> 
      <input type="hidden" name="action" value="SEND"></form>
  </body>
</html>
