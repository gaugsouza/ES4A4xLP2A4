import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/Formularios.css'
class Cadastro extends Component{
    state ={
        errMessage: null,
        nome:null,
        email: null,
        senha: null
    }
    
    handleChange = (e) =>{
        this.setState({
                [e.target.name]: e.target.value
        });
    }

    handleSubmit = (e) =>{
        e.preventDefault();
        let {senha} = this.state;
        let confirmacao = document.forms[0].confirmarsenha.value;
        let errMessage = '';
        if(senha.length < 8){
            errMessage = 'Senha deve conter pelo menos 8 caracteres';
        }else if(senha !== confirmacao){
            errMessage = 'Senhas informadas não coincidem';
        }else{
            const {addUsuario} = this.props;
            let usuario = {nome:this.state.nome, email:this.state.email, senha:this.state.senha}
            addUsuario(usuario);
            this.props.history.push("/cadastroSucesso")
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
                    <label>Nome <input type="text" name="nome" onChange={this.handleChange}/></label>
                    <label>Email <input type="text" name="email" onChange={this.handleChange}/></label>
                    <label>Senha <input type="password" name="senha" onChange={this.handleChange}/></label>
                    <label>Confirmar senha <input type="password" name="confirmarsenha"/></label>
                    <span className="aviso">{this.state.errMessage}</span>
                    <input type="submit" className="btn form-submit" value="Cadastrar"/>
                    <div className="links-cadastro"><Link to="/login">Já possui uma conta?</Link></div>
                </form>
            </div>
        )
    }
}

export default Cadastro;