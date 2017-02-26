<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VueProduit</title>

</head>
<body class="text text-center">
 <form action="controleur.php" method="post">
   <input type="hidden" value="${model.mode}" name="mode"/>
   <h1 >Enregistrement de produits</h1>
   <table class="table1">
       <c:if test="${model.mode=='ajout' }">
          <tr>
         <td class="btn  btn-lg active" style="color:blue;font-size:15px">Référence</td>
         <td><input type="text" name="reference" value="${model.logement.type}"/></td>
         <td></td>
         </tr>
       </c:if>
       <c:if test="${model.mode=='edit' }">
        <tr>
       <td >type</td><td>
       <input type="hidden" name="type" value="${model.logement.type}"/></td>
       <td></td>
       </tr>
       </c:if>
       <tr>
       <td c>latitude</td><td>
       <input type="text" name="latitude" value="${model.logement.latitude}"/></td>
       <td></td>
       </tr>
       <tr>
       <td >longitude</td><td>
       <input type="text" name="longitude" value="${model.logement.longitude}"/></td>
       <td></td>
       </tr>
       <tr>
       <td >chambre</td><td>
       <input type="text" name="chambre" value="${model.logement.nombreChambre}"/></td>
       <td></td>
       </tr>
        <tr>
       <td >bain</td><td>
       <input type="text" name="bain" value="${model.logement.nombreBain}"/></td>
       <td></td>
       </tr>
       <tr>
       <td >salon</td><td>
       <input type="text" name="salon" value="${model.logement.nombreSalon}"/></td>
       <td></td>
       </tr>
       <tr>
       <td>
       <input class="btn  btn-lg active" type="submit" name="action" value="Enregistrer"/></td>
       </tr>
   </table>
   </form>
            <p> ${model.mode }</p>
      <c:forEach items="${model.logements}" var="p"> 
     <p> ${p.latitude }</p>
      </c:forEach>
</body>
</html>