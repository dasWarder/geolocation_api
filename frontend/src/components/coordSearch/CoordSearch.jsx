import CoordSearchForm from "./CoordSearchForm";
import CoordResultTable from "./CoordResultTable";
import CoordinatesService from "../../services/CoordinatesService";
import {useState} from "react";


const CoordSearch = () => {

    const [places, setPlaces] = useState([]);

    const getCoordinates = (coordinates) => {

        console.log('CoordSearch component received coordinates: ' + coordinates);

        CoordinatesService.getLocationsByCoordinates(coordinates).then(r => setPlaces(r.data)).catch(e => {
            console.log('There is no possible to find a place like this');
        });
    }

    return (
        <div className="mt-5">
            <CoordSearchForm fetchData={getCoordinates}/>
            <CoordResultTable places={places}/>
        </div>
    );
};

export default CoordSearch;