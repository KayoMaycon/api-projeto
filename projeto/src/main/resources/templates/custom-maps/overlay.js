//--------- MeuMapa -----------

class OverlayMap {
    constructor(tileSize) { // construtor que passa o tamanho do bloco
        this.tileSize = tileSize;
    }

    getTile(coord, zoom, ownerDocument) { // ele vai montando os blocos
        var div = ownerDocument.createElement('div');
        div.style.width = this.tileSize.width+'px';
        div.style.height = this.tileSize.height+'px';
        div.style.fontSize = '10px';
        div.style.borderStyle = 'solid';
        div.style.borderWidth = '1px';
        div.style.borderColor = '#333';
        return div;
    }
}

var map;
/*var button = document.querySelector('#satellite');
button.addEventListener('click', function() {
    map.setMapTypeId('satellite');
});*/
function initMap() {
    var mapOptions = {
        center: {lat: -3.716816, lng: -38.519115},
        zoom: 8
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);
    map.overlayMapTypes.insertAt(0, new OverlayMap(new google.maps.Size(256, 256)));

}