import React, { Component } from 'react';
import { Container, Row } from 'reactstrap';
import LazyLoad from "react-lazyload";
import Loading from "../images/Loading";
import Product from "./Product";
import axios from "../../api";

export default class ProductList extends Component {
  state = {
    productIds: null
  };

  componentDidMount(){
    axios.get('/products').then(response => {
      console.log('response', response);
    });
    this.setState({
      productIds: [1,2,3,4,5,6,7,8,9,10]
    });
  }

  renderProducts() {
    const { productIds } = this.state;
    if(!productIds){
      return(
        <Loading />
      );
    }
    let render = [];
    for(let i = 0; i < productIds.length; i++) {
      render.push(
        <LazyLoad placeholder={<Loading />} key={productIds[i]} height="50px" >
          <Product productId={productIds[i]} />
        </LazyLoad>
      )
    }

    return render;
  }

  render(){
    return (
      <Container>
        <Row>
          {this.renderProducts()}
        </Row>
      </Container>
    );
  }
}