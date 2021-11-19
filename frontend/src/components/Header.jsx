import "react-bootstrap";
import {Container, Nav, Navbar} from "react-bootstrap";
import React from "react";

const Header = () => {

    return(
        <div>
            <Navbar bg="primary" variant="dark">
                 <Container className="mt-4 mb-4" fluid="lg">
                     <Navbar.Brand><h1>Geolocation API</h1></Navbar.Brand>
                  </Container>
            </Navbar>
        </div>
    )
};

export default Header;