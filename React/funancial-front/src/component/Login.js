import React, { useEffect, useState } from 'react';
import {withRouter} from 'react-router-dom';
import {logarUsuario} from '../util/autenticacao';
import { Link } from 'react-router-dom';
import '../css/Forms.css'
import { nullKeyValidator } from '../util/nullKeyValidator'
const Login = ({setTitle, history}) => {
    useEffect(() =>{
        setTitle('Login');
    });
    const [usuario, setUsuario] = useState({
        email: null,
        senha:null
    });
    const [mensagemErro, setMensagemErro] = useState(null);

    const handleChange = e => {
        setUsuario({
            ...usuario,
            [e.target.name]: e.target.value
        });
    }

    const handleSubmit = e =>{
        try{
            e.preventDefault();
            nullKeyValidator(usuario)    
            logarUsuario(usuario)
            .then(({data}) =>{
                console.log(data);
                history.push("/");
            }).catch(error =>{
                setMensagemErro(error.message);
            })
        }catch(e){
            setMensagemErro(e.message);
        }        
    }

    return(
        <div className="login-form form-container">
            <h3>Login</h3>
            <form method="post" onSubmit={handleSubmit}>
                <label>
                    <span>E-mail:</span>
                    <input type="email" name="email" onChange={handleChange}/>
                </label>
                <label>
                    <span>Senha:</span>
                    <input type="password" name="senha" onChange={handleChange}/>
                </label>
                <span>{mensagemErro}</span>
                <input type="submit" name="enviar" value="Entrar"/>
            </form>
            <div className="links-uteis">
                <a href="#">Esqueci a senha</a>
                <Link to="cadastro">Não sou cadastrado</Link>
            </div>
        </div>
    )
}

export default withRouter(Login);
