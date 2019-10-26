import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/Formularios.css'
class Cadastro extends Component{
    state ={
        errMessage: '',
        usuario:{
            nome:'',
            email: '',
            senha: ''
        }
    }
    
    handleChange = (e) =>{
        this.setState({
            usuario:{
                [e.target.name]: e.target.value
            }
        });
    }

    handleSubmit = (e) =>{
        e.preventDefault();
        let {senha} = this.state.usuario;
        let confirmacao = document.forms[0].confirmarsenha.value;
        let errMessage = '';
        if(senha.length < 8){
            errMessage = 'Senha deve conter pelo menos 8 caracteres';
        }else if(senha !== confirmacao){
            errMessage = 'Senhas informadas não coincidem';
        }

        this.setState({
            errMessage
        });
        console.log(this.state.usuario);
    }
    render(){
        return(
            <div className="form_container">
                <h2>Cadastro</h2>
                <form method="post" action="/jogar" onSubmit={this.handleSubmit}>
                    <label>Nome <input type="text" name="nome"/></label>
                    <label>Email <input type="text" name="email"/></label>
                    <label>Senha <input type="password" name="senha" onChange={this.handleChange}/></label>
                    <label>Confirmar senha <input type="password" name="confirmarsenha"/></label>
                    <span className="aviso">{this.state.errMessage}</span>
                    <input type="submit" className="btn form-submit" value="Entrar"/>
                    <div className="links-cadastro"><Link to="#">Esqueceu a senha?</Link> <br/><Link to="/cadastro">Cadastrar</Link></div>
                </form>
            </div>
        )
    }
}

export default Cadastro;