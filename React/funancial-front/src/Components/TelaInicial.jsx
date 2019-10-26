import React, { Component } from 'react';
import '../CSS/TelaInicial.css';
import { Link } from 'react-router-dom';
import {exibirMenu} from '../JS/TelaInicial'
class TelaInicial extends Component{
    handleClick = (e) =>{
        //TODO: Verificação se usuário está logado ou não.
        e.preventDefault();
        exibirMenu('secao_cadastro');
    }
    render(){
        return(
            <div className="telaInicial">

                <Link to="/jogar" className="btn jogar" onClick={this.handleClick}>Jogar</Link>
                <div className="infos_jogador">
                    <Link to="/perfil" className="btn perfil">Perfil</Link>
                    <Link to="/estatisticas" className="btn estatisticas">Estatísticas</Link>
                </div>
                <div className="secao_cadastro">
                    <Link to="/login" className="btn login">Login</Link>
                    <Link to="/cadastro" className="btn cadastro">Cadastro</Link>
                </div>
                <Link to="/sobre" className="link sobre">Sobre</Link>
            </div>
        );
    }
}

export default TelaInicial;