import React from 'react';
import { Row, Col, Jumbotron, Button } from 'reactstrap';
import ProductList from '../components/product/ProductList';
import WelcomeWarningPopUp from '../components/popup/WelcomeWarningPopUp';

const HomePage = () => (
  <Row>
    <WelcomeWarningPopUp />
    <Col>
      <Jumbotron>
        <h1 className="display-3">Welcome v Pivních Suvenýrech!</h1>
        <p className="lead">
          <Button outline color="primary">Good bye</Button>
        </p>
        <ProductList />
      </Jumbotron>
    </Col>
  </Row>
  );

export default HomePage;
