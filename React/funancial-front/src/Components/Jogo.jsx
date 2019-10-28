import React, { Component } from 'react';
import { Link } from 'react-router-dom';
class Jogo extends Component{
    render(){
        return(
            <div>
                <p>Jogo</p>
                <Link to="/">Voltar para a home</Link>
            </div>
            
        )
    }
}

export default Jogo;