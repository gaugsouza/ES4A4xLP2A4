import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
const TelaInicial = () => {
    useEffect(() =>{
        document.title = "Funancial - Economy for Kids";
    })
    return(
        <div>
            <Link to="/login">Login</Link>
            <Link to="/cadastro">Cadastro</Link>
        </div>
    )
};

export default TelaInicial;
