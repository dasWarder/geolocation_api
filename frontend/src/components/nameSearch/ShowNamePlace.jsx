import {logDOM} from "@testing-library/react";
import {map} from "react-bootstrap/ElementChildren";
import {Alert, ListGroup} from "react-bootstrap";


const ShowNamePlace = (props) => {

    const validatePlaceOrShowDefaultMessage = (place) => {

        if(place.length === 0) {
            return(
                <div>
                    <h4 className="mt-5 text-center">There is no a such place</h4>
                </div>
            );
        } else {
            console.log(`Place received: ${place.toString()}`)
            return (
                <Alert className="alert-light mt-3">
                {place.map(p =>
                        <ListGroup horizontal='xl' className="my-3">
                            <ListGroup.Item variant='danger'>Latitude: {p.lat}</ListGroup.Item>
                            <ListGroup.Item variant="success">Longitude: {p.lng}</ListGroup.Item>
                        </ListGroup>
                    )}
                </Alert>
            );
        }
    }

    return(
        <div>
            {validatePlaceOrShowDefaultMessage(props.place)}
        </div>
    );
};

export default ShowNamePlace;