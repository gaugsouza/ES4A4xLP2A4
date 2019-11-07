import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import {Helmet} from 'react-helmet';
import '../CSS/TelaInicial.css';
import { Link } from 'react-router-dom';
import {exibirMenu} from '../JS/TelaInicial';
import Login from './Login';
import Cadastro from './Cadastro';
import {  BrowserRouter as Router} from 'react-router-dom';

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

    displayComponent = (elementRender) =>{
        let forceRender = document.getElementsByClassName('force-render')[0];
        ReactDOM.render(<Router>{elementRender}</Router>, forceRender);
    }
    render(){
        return(
            <div className="tela-inicial">
                <Helmet>
                    <title>Funancial - Economy for Kids</title>
                </Helmet>
                <h1 className="title">Funancial - Economy for Kids</h1>
                <div className="floor"></div>
                <div className="container">
                    <div className="door">
                    <Link to="/jogar" className="acessar placa" onClick={this.handleClick}>Acessar</Link>
                    <a className="login placa acesso-link" onClick={()=>{this.displayComponent(<Login/>)}}>Login</a>
                    <a className="cadastro placa acesso-link" onClick={()=>{this.displayComponent(<Cadastro addUsuario={this.props.addUsuario} history={this.props.history}/>)}}>Cadastro</a>
                    </div>
                    <div className="shelf-container">
                        <div className="shelf">
                        </div>
                            <div className="pernas"></div>
                            <div className="frame"></div>
                    </div>
                    <div className="painting"></div>
                    <div className="force-render">

                    </div>
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