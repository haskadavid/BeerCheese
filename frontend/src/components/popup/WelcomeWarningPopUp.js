import React, { Component }  from 'react';
import { Modal, ModalHeader, ModalFooter, Button } from 'reactstrap';
import localizedTexts from '../../text_localization/LocalizedStrings';

export default class WelcomeWarningPopUp extends Component {
  state = {
    isOpen: true
  };

  render(){
    return(
      <Modal isOpen={this.state.isOpen}>
        <ModalHeader>{localizedTexts.WelcomeWarningPopUp.message}</ModalHeader>
        <ModalFooter>
          <Button onClick={() => this.setState({isOpen:false})}>{localizedTexts.WelcomeWarningPopUp.okBtn}</Button>
        </ModalFooter>
      </Modal>
    )
  }
}