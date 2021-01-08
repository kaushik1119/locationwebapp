<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Create Location</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form action="updateLoc" method="post">
    <pre>
    Id: <input type="text" name="id" value="${location.id}" hidden/>
    Code: <input type="text" name="code" value="${location.code}"/>
    Name: <input type="text" name="name" value="${location.name}"/>
    Type: Urban <input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''}/>
          Rural <input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/>
    <input type="submit" value="save"/>

        </pre>
</form>
${msg}
</body>
</html>