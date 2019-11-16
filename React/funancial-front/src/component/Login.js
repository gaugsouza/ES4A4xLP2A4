import React, { useEffect, useState } from 'react';
import {withRouter} from 'react-router-dom';
import {logarUsuario} from '../util/autenticacao';
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
        e.preventDefault();
        for(let key in usuario){
            if(usuario[key] === null){
                setMensagemErro(`Campo de ${key.charAt(0).toUpperCase() + key.slice(1)} não pode estar vazio`);
                return false;
            }
        }

        logarUsuario(usuario)
        .then(({data}) =>{
            history.push("/");
        }).catch(error =>{
            setMensagemErro('Usuário ou senha incoretos');
        })

        
    }

    return(
        <div className="login-form">
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
        </div>
    )
}

export default withRouter(Login);
