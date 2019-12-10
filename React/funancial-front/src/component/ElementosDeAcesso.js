import React from 'react';
import { Link } from 'react-router-dom';
import '../css/ElementosDeAcesso.css';
const ElementosDeAcesso = () => {
    return(
        <div className="access-content">
            <Link to="/login">Login</Link>
            <Link to="/cadastro">Cadastro</Link>
            <Link to="/sobre">Sobre</Link>
        </div>
    );  
};

export default ElementosDeAcesso;
