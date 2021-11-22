import {Col, Form, Row} from "react-bootstrap";
import {Button} from "react-bootstrap";
import {useState} from "react";

const NameSearchForm = (props) => {

    const [name, setName] = useState('');

    const onChange = (e) => {
        setName(e.target.value);
    }

    const fetchName = (e) => {
        e.preventDefault();
        props.findFunction(name);
    }

    return(
        <Form onSubmit={fetchName}>
            <Row>
                <h1>Location name:</h1>
                <Col>
                    <Form.Control value={name} onChange={event => onChange(event)} placeholder="Enter name" />
                </Col>
                <Col>
                    <Button className="px-5" type="submit" variant="success">Find</Button>
                </Col>
            </Row>
        </Form>
    );
};

export default NameSearchForm;