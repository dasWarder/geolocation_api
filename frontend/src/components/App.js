import Header from "./Header";
import Main from "./Main";
import {Container} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  return (
    <Container>
      <Header/>
        <Main/>
    </Container>
  );
}

export default App;
