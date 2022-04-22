<template lang="">
    <div>
        <div id="map"></div>
    </div>
</template>
<script>
import "leaflet/dist/leaflet.css";
import L from "leaflet";

export default {
    name:"MapaConInfo",
    data(){
        return{
            map:null
        }
    },
    created(){

    },
     mounted() {
    this.map = L.map("map").setView([51.959, -8.623], 12);
    L.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", {
      attribution:
        '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.map);
  },
  beforeDestroy() {
    if (this.map) {
      this.map.remove();
    }
  }
}
</script>
<style scoped>

   #map { height: 400px; }
</style>