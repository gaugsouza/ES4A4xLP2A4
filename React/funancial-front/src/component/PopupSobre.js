import React, { useEffect, useState } from 'react';
import {withRouter} from 'react-router-dom';
import {logarUsuario} from '../util/autenticacao';
import { Link } from 'react-router-dom';
import '../css/Forms.css'

const Sobre = ({setTitle, history}) => {
    useEffect(() =>{
        setTitle('Sobre');
    });
    
    const loremIpsum = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';

    const launchModal = ({ size, ...props }) => (event) => {
        portal(({ onClose }) => (
            <Modal {...props} size={size} onClose={onClose}>
            	<Modal.Header>
            		<Modal.Title>
            			Sobre a Empresa
            		</Modal.Title>
            	</Modal.Header>
            	<Modal.Body>
                    {loremIpsum}
                </Modal.Body>
                <Modal.Footer>
                    <Button onClick={onClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        ));
    };

    <Fragment>
        <Button btnStyle="primary" onClick={launchModal({ size: 'sm' })}>
            Sobre
        </Button>
    </Fragment>
}
export default withRouter(Sobre);