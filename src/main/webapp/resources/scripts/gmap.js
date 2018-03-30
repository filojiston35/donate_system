    var currentMarker = null;
     function handlePointClick(event) 
     {
         if(currentMarker!=null)
             currentMarker.setMap(null);
         
            document.getElementById('lat').value = event.latLng.lat();
            document.getElementById('lng').value = event.latLng.lng();
            currentMarker = new google.maps.Marker({
                position:new google.maps.LatLng(event.latLng.lat(), event.latLng.lng())
            });
 
            PF('map').addOverlay(currentMarker);
 
            PF('dlg').show();
          
    }
 
    function markerAddComplete() {
        
        PF('dlg').hide();
    }
 
    function cancel() {
        document.getElementById('lat').value=0.0;
        document.getElementById('lng').value=0.0;
        PF('dlg').hide();
        currentMarker.setMap(null);
        currentMarker = null;
 
        return false;
    }