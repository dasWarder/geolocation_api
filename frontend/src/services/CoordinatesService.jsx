import axios from "axios";

const BASE_URL = 'http://localhost:8080/geolocation'

class CoordinatesService {

    getLocationsByCoordinates(coordinates) {
        console.log('Receive coordinates: ' + coordinates);
        return axios.get(BASE_URL + `?lat=${coordinates.lat}&lng=${coordinates.lng}`);
    }

    getPlaceByName(name) {
        console.log('Receive a place based on the name ' + name);
        return axios.get(BASE_URL + `/${name}`);
    }

}

export default new CoordinatesService();