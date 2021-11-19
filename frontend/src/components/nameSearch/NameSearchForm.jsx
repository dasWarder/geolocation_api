import {Col, Form, Row} from "react-bootstrap";
import {Button} from "react-bootstrap";


const NameSearchForm = (props) => {

    return(
        <Form>
            <Row>
                <h1>Location name:</h1>
                <Col>
                    <Form.Control placeholder="Enter name" />
                </Col>
                <Col>
                    <Button className="px-5" type="submit" variant="success">Find</Button>
                </Col>
            </Row>
        </Form>
    );
};

export default NameSearchForm;