import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/NotFound.css'
class NotFound extends Component{
    render(){
        return(
            <div className="notFound">
                <h3>Opa!</h3>
                <h5>A página que você está procurando não existe. <br/>Desculpe o transtorno</h5>
                <Link to="/">Voltar para a home</Link>
            </div>
        );
    }
}

export default NotFound;