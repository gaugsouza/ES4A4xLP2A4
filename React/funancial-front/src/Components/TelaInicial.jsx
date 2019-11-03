import React, { Component } from 'react';
import {Helmet} from 'react-helmet';
import '../CSS/TelaInicial.css';
import { Link } from 'react-router-dom';
import {exibirMenu} from '../JS/TelaInicial'

//TODO: verificar possibilidade de fazer cada parte daqui ser um componente funcional
//E deixar visível alguns só se usuario estiver logado
class TelaInicial extends Component{
    handleClick = (e) =>{
        //TODO: Criar sessão para usuário
        e.preventDefault();
        if(this.props.usuarioLogado.id !== undefined && this.props.usuarioLogado.id !== null){
            this.props.history.push('/jogar');
        }else{
            exibirMenu('acesso-link');
        }
        
    }
    render(){
        return(
            <div className="tela-inicial">
                <Helmet>
                    <title>Funancial - Economy for Kids</title>
                </Helmet>
                <div className="floor"></div>
                <div className="container">
                    <div className="door">
                    <Link to="/jogar" className="acessar placa" onClick={this.handleClick}>Acessar</Link>
                    <Link to="/login" className="login placa acesso-link">Login</Link>
                    <Link to="/cadastro" className="cadastro placa acesso-link">Cadastro</Link>
                    </div>
                    <div className="abajour"></div>
                    <div className="shelf"></div>
                </div>
            </div>
            /*<div className="telaInicial">

                <Link to="/jogar" className="btn jogar" onClick={this.handleClick}>Jogar</Link>
                <div className="secao_cadastro">
                    <Link to="/login" className="btn login">Login</Link>
                    <Link to="/cadastro" className="btn cadastro">Cadastro</Link>
                </div>
                <Link to="/sobre" className="link sobre">Sobre</Link>
            </div>*/
        );
    }
}

export default TelaInicial;