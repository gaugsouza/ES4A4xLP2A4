import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/Formularios.css';
import axios from 'axios';
const Login = ({logar, usuarios, history}) =>{
    const [usuario, setUsuario] = useState({
        email:null,
        senha:null,
    });
    const [errMsg, setErrMsg] = useState(null);
    const API_URL = 'http://localhost:3000/usuarios';
    const handleChange = e =>{
        setUsuario({
            ...usuario,
            [e.target.name]:e.target.value
        });
    }

    const handleSubmit = e =>{
        e.preventDefault();
        let usuariosApi = [];
        axios.get(API_URL)
        .then(res =>{
            usuariosApi = [...usuariosApi, res.data];
        });
        console.log(usuariosApi);
        console.log(API_URL);
        let {email, senha} = usuario;
        let usuarioALogar = usuariosApi.filter(usuario => usuario.email === email && usuario.senha === senha)[0];

        if(usuarioALogar === null || usuarioALogar === undefined){
            setErrMsg( 'Email ou senha incorretos');
            return false;
        }
        logar(usuarioALogar);
        history.push('/jogar');
        /*
        let {email, senha} = usuario;
        let usuarioLogado = usuarios.filter(usuario => usuario.email === email && usuario.senha === senha)[0];

        if(usuarioLogado === null || usuarioLogado === undefined){
            setErrMsg( 'Email ou senha incorretos');
            return false;
        }

        logar(usuarioLogado);
        history.push('/jogar');*/
        
    }

    return(
        <div className="form-container">
            <h2>Login</h2>
            <form method="post" action="/jogar" onSubmit={handleSubmit}>
                <label>Email <input type="text" name="email" onChange={handleChange}/></label>
                <label>Senha <input type="password" name="senha" onChange={handleChange}/></label>
                <span className="aviso">{errMsg}</span>
                <input type="submit" className="btn form-submit" value="Entrar" name="login"/>
                <div className="links-cadastro"><Link to="#">Esqueceu a senha?</Link> <br/><Link to="/cadastro">Cadastrar</Link></div>
            </form>
        </div>
    );

}

export default Login;

/*import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/Formularios.css'
class Login extends Component{
    state = {
        email: null,
        senha: null,
        errMsg: null
    }
    
    handleChange = (e) =>{
        this.setState({
                [e.target.name]: e.target.value
        });
    }

    handleSubmit = (e) =>{
        e.preventDefault();
        let {usuarios} = this.props;
        let {email, senha} = this.state;
        let usuario = usuarios.filter(usuario => usuario.email === email && usuario.senha === senha)[0];
        if(usuario !== null && usuario !== undefined){
            let {logar} = this.props;
            logar(usuario);
            this.props.history.push('/jogar');
        }else{
            this.setState({
                errMsg: 'Email ou senha incorretos'
            });
        }

        
    }
    render(){
        return(
        <div className="form-container">
            <h2>Login</h2>
            <form method="post" action="/jogar" onSubmit={this.handleSubmit}>
                <label>Email <input type="text" name="email" onChange={this.handleChange}/></label>
                <label>Senha <input type="password" name="senha" onChange={this.handleChange}/></label>
                <span className="aviso">{this.state.errMsg}</span>
                <input type="submit" className="btn form-submit" value="Entrar"/>
                <div className="links-cadastro"><Link to="#">Esqueceu a senha?</Link> <br/><Link to="/cadastro">Cadastrar</Link></div>
            </form>
        </div>
        
        )
    }
}

export default Login;*/