// MapType
// maxZoom*
// tileSize*
// name
// minZoom
// alt

// getTile(coord, zoom, docu)*
// releaseTile(tile)

//--------- MeuMapa -----------

class MeuMapa {
    constructor(tileSize) {
        this.tileSize = tileSize;
        this.maxZoom = 18;
        this.name = 'Meu Mapa';
        this.alt = 'O mapa não carregou';
    }

    getTile(coord, zoom, ownerDocument) {
        var div = ownerDocument.createElement('div');
        div.innerHTML = 'Kayo Maycon';
        div.style.width = this.tileSize.width+'px';
        div.style.height = this.tileSize.height+'px';
        div.style.fontSize = '10px';
        div.style.backgroundColor = '#ddd';
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
        zoom: 8,
        mapTypeId: 'meumapa', // roadmap, satellite, hybrid, terrain
        mapTypeControlOptions: {
            mapTypeIds: ['roadmap', 'meumapa']
        }
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);

    map.mapTypes.set('meumapa', new MeuMapa(new google.maps.Size(256, 256)));
}