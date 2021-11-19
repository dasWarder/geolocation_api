import {Col, Form, Row} from "react-bootstrap";
import {Button} from "react-bootstrap";
import { useState} from "react";

const CoordSearchForm = (props) => {


    const[coordData, setCoordData] = useState({
        'lat': 0.0,
        'lng': 0.0
    });

    const fetchCoordinates = (e) => {
        e.preventDefault();
        props.fetchData(coordData);
    }

    const onChange = (e, val) => {

        let res = {
            'lat': 0.0,
            'lng': 0.0
        };

        setCoordData((p) => {

            let cur = e.target.value;

            if(val === 'lat') {
                res.lat = cur;
                res.lng = p.lng;
            }
            if(val == 'lng') {
                res.lng = cur;
                res.lat = p.lat;
            }

            return res;
        });
    }

    return(
        <Form onSubmit={fetchCoordinates}>
            <Row>
                <h1>Coordinates:</h1>
                <Col>
                    <Form.Control value={coordData.lat} onChange={event => onChange(event, 'lat')} placeholder="Enter latitude" />
                </Col>
                <Col>
                    <Form.Control value={coordData.lng} onChange={event => onChange(event,'lng')} placeholder="Enter longitude" />
                </Col>
                <Col>
                    <Button className="px-5" type="submit" variant="success">Find</Button>
                </Col>
            </Row>
        </Form>
    );
};

export default CoordSearchForm;

