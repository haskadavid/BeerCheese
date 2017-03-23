import React, { Component } from 'react';
import {
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Collapse,
  Nav,
  NavItem,
  NavLink
} from 'reactstrap';
import { Link } from 'react-router';

class NavBar extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isOpen: false
    };
  }

  toggle = () => {
    this.setState({
      isOpen: !this.state.isOpen
    });
  };

  //TODO Upravit navbar tak, aby odpovidal zadani z wireframu

  render() {
    return (
      <Navbar light toggleable>
        <NavbarToggler right onClick={this.toggle} />
        <NavbarBrand tag={Link} to="/">pivní suvenýry</NavbarBrand>
        <Collapse isOpen={this.state.isOpen} navbar>
          <Nav className="ml-auto" navbar>
            <NavItem>
              <NavLink tag={Link} to="/components/">Login</NavLink>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
    );
  }
}

export default NavBar;
