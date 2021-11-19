import CoordSearchForm from "./CoordSearchForm";
import CoordResultTable from "./CoordResultTable";
import CoordinatesService from "../../services/CoordinatesService";
import {useState} from "react";
import {ListGroup} from "react-bootstrap";


const CoordSearch = () => {

    const[places, setPlaces] = useState([]);


    const getCoordinates = (coordinates) => {

        console.log('CoordSearch component received coordinates: ' + coordinates);

        CoordinatesService.getLocationsByCoordinates(coordinates).then(r => setPlaces(r.data));
    }

    return(
      <div className="mt-5">
         <CoordSearchForm fetchData={getCoordinates}/>
         <CoordResultTable/>
      </div>
    );
};

export default CoordSearch;