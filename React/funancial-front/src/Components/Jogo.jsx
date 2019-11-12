import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {Helmet} from 'react-helmet';
class Jogo extends Component{
    render(){
        return(
            <div>
                <Helmet>
                    <title>Jogo</title>
                </Helmet>
                <p>Jogo</p>
                <Link to="/">Voltar para a home</Link>
            </div>
            
        )
    }
}

export default Jogo;