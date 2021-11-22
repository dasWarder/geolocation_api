import 'react-bootstrap';
import {Table} from "react-bootstrap";

const CoordResultTable = (props) => {

    const showTableOrMessage = (places) => {

        if(places.length === 0) {

            console.log('EMPTY LIST');

            return (
                <div className="mt-5 text-center">
                    <h5>There are no nearest places based on this input data</h5>
                </div>
            );

        } else {
           return(
            <Table striped bordered hover variant="light" className="mt-3 mb-3">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                </tr>
                </thead>
                <tbody>
                {props.places.map(place =>
                    <tr key={place.id}>
                        <td>{place.name}</td>
                        <td>{place.address}</td>
                        <td>{place.lat}</td>
                        <td>{place.lng}</td>
                    </tr>
                )}
                </tbody>
            </Table>
           )
        }
    };

    return (
        showTableOrMessage(props.places)
    );
};

export default CoordResultTable;