
function initMap() {
  var directionsService = new google.maps.DirectionsService;
  var directionsDisplay = new google.maps.DirectionsRenderer;
  var latitude=$("#latitude").textContent();
 var longitude=$("#longitude").textContext();
  var myLatLng = new google.maps.LatLng(latitude,longitude);
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 15,
    center: myLatLng
  });
  directionsDisplay.setMap(map);
  var marker = new google.maps.Marker({
      position: myLatLng,
      map: map,
      opacity :0.5,
      title: 'appartemenet'
  });

  
    calculateAndDisplayRoute(directionsService, directionsDisplay);
}
initMap();
