var map;
/*var button = document.querySelector('#satellite');
button.addEventListener('click', function() {
    map.setMapTypeId('satellite');
});*/
function initMap() {
    var mapOptions = {
        center: {lat: -3.716816, lng: -38.519115},
        zoom: 8,
        mapTypeId: 'roadmap' // roadmap, satellite, hybrid, terrain
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);
}
