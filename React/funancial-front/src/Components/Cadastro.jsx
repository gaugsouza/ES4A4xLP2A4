import React, {useState} from 'react';
import {Link} from 'react-router-dom';
import '../CSS/Formularios.css';

const Cadastro = ({addUsuario, history}) =>{
    const [usuario, setUsuario] = useState({
        nome:null,
        email:null,
        senha:null,
        confirmarsenha:null
    });

    const [errMsg, setErrMsg] = useState(null);

    const handleChange = e =>{
        setUsuario({
            ...usuario,
            [e.target.name]:e.target.value
        });
    }
    
    const handleSubmit = e =>{
        e.preventDefault();
        for(let key in usuario){
            if(usuario[key] === null && key !== 'confirmarsenha'){
                setErrMsg(`Campo de ${key.charAt(0).toUpperCase() + key.slice(1)} não pode ser nulo`);
                return false;
            }
        }

        let {senha, confirmarsenha} = usuario;
        if(senha.length < 8){
            setErrMsg('Senha deve ter pelo menos 8 caracteres');
            return false;
        }
        if(senha !== confirmarsenha){
            setErrMsg('Senhas informadas diferem');
            return false;
        }
        
        addUsuario(usuario);
        history.push("/cadastroSucesso");
    }


    return(
        <div className="form-container">
            <h2>Cadastro</h2>
            <form method="post" action="/jogar" onSubmit={handleSubmit}>
                <label>Nome <input type="text" name="nome" onChange={handleChange}/></label>
                <label>Email <input type="text" name="email" onChange={handleChange}/></label>
                <label>Senha <input type="password" name="senha" onChange={handleChange}/></label>
                <label>Confirmar senha <input type="password" name="confirmarsenha" onChange={handleChange}/></label>
                <span className="aviso">{errMsg}</span>
                <input type="submit" className="btn form-submit" value="Cadastrar"/>
                <div className="links-cadastro"><Link to="/login">Já possui uma conta?</Link></div>
            </form>
        </div>
    )

}

export default Cadastro;


/*import React, { Component } from 'react';
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
            <div className="form-container">
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

export default Cadastro;*/