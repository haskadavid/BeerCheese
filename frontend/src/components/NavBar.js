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
import localizedTexts from '../text_localization/LocalizedStrings';

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
        <NavbarBrand tag={Link} to="/">{localizedTexts.NavBar.pageName}</NavbarBrand>
        <Collapse isOpen={this.state.isOpen} navbar>
          <Nav className="ml-auto" navbar>
            <NavItem>
              <NavLink tag={Link} to="/components/">{localizedTexts.NavBar.logIn}</NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={Link} to="/components/">{localizedTexts.NavBar.signUp}</NavLink>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
    );
  }
}

export default NavBar;
