import NameSearchForm from "./NameSearchForm";
import CoordinatesService from "../../services/CoordinatesService";
import {useState} from "react";
import ShowNamePlace from "./ShowNamePlace";

const NameSearch = () => {

    const [place, setPlace] = useState('');

    const getPlaceByName = (name) => {

        console.log('Find a place with the name = ' + name);

        CoordinatesService.getPlaceByName(name).then(r => setPlace(r.data)).catch(e =>
            console.log('There are no places in the database with the name = ', name)
        );
    }

    return (
        <div className="mt-5">
            <NameSearchForm findFunction={getPlaceByName}/>
            <ShowNamePlace place={place}/>
        </div>
    )
};

export default NameSearch;