<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

</head>
<body>
<br>
      <div>
      <button class="btn btn-primary btn-block" style="font-size:150%;">Gestion de stock de materiels Informatiques</button>
      
      </div>
      <br><br><br>
      <div style="text-align:center;border:2px dotted gray;">
      <form action="Authentification" method="post" >
          
              <p class="btn btn-primary btn-block" style="font-size:100%">Authentifiez-vous SVP</p> 
              <br>
             <span class="btn  btn-lg active">Login:&nbsp;<input type="text" name="login"/></span> 
              <br><br>
             <span class="btn  btn-lg active">Password: <input type="password" name="password" /></span>
              <br><br>
              &nbsp;
              <span class="btn btn-primary btn-lg active" style="font-size:100%;"><input type="submit" value="Connexion"/></span>
              <br>
      </form>
      </div>
</body>
</html>