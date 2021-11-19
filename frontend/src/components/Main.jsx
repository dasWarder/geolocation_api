import {Alert, Nav} from "react-bootstrap";
import {useState} from "react";
import About from "./About"
import CoordSearch from "./coordSearch/CoordSearch";
import NameSearch from "./nameSearch/NameSearch";


const Main = () => {

    const info = <About/>
    const coordSearchForm = <CoordSearch/>
    const nameSearch = <NameSearch/>;

    let [content, setContent] = useState(coordSearchForm);

    let changeContent = (e) => {
        const val = e;

        if (val === 'info') {
            setContent(info);
        } else if (val === 'coord') {
            setContent(coordSearchForm);
        } else if (val === 'name') {
            setContent(nameSearch);
        }
    }

    return (
        <div>
            <Nav variant="tabs">
                <Nav.Item>
                    <Nav.Link onClick={() => changeContent('info')}>Information</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link onClick={() => changeContent('coord')}>Find by coordinates</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link onClick={() => changeContent('name')}>Find by name</Nav.Link>
                </Nav.Item>
            </Nav>
            <div>
                <Alert>
                    {content}
                </Alert>
            </div>
        </div>
    );
};

export default Main;