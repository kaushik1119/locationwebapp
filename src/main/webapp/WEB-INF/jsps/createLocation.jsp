<!DOCTYPE HTML>
<html>
<head>
    <title>Create Location</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form action="saveLoc" method="post">
    <pre>
    <%--Id: <input type="text" name="id"/>--%>
    Code: <input type="text" name="code"/>
    Name: <input type="text" name="name"/>
    Type: Urban <input type="radio" name="type" value="URBAN"/>
          Rural <input type="radio" name="type" value="RURAL"/>
    <input type="submit" value="save"/>

        </pre>
</form>
${msg}
<a href="displayLoc">Display locations</a>

</body>
</html>