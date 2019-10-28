import React, { Component } from 'react';
import { Link } from 'react-router-dom';
class CadastroSucesso extends Component{
    render(){
        return(
            <div>
                <p>Cadastro realizado com sucesso</p>
                <Link to='/login'>Acessar jogo agora</Link>
            </div>
        )
    }
}

export default CadastroSucesso;