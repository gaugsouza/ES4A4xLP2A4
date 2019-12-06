import React from 'react';
import { Link } from 'react-router-dom';
import '../css/ElementosDeAcesso.css';
const ElementosDeAcesso = () => {
    return(
        <div className="access-content">
            <Link to="/login" className="login">Login</Link>
            <Link to="/cadastro">Cadastro</Link>
        </div>
    );  
};

export default ElementosDeAcesso;
