import axios from "axios";

const BASE_URL = 'http://localhost:8080/geolocation'

class CoordinatesService {

    getLocationsByCoordinates(coordinates) {

        console.log('Receive coordinates: ' + coordinates);

        try{

            return axios.get(BASE_URL + `?lat=${coordinates.lat}&lng=${coordinates.lng}`);

        } catch (e) {

            return {
                'error_message': 'param(s) not valid'
            };
        }
    }

}

export default new CoordinatesService();