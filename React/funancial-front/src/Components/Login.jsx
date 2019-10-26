import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../CSS/Formularios.css'
class Login extends Component{
    render(){
        return(
        <div className="form_container">
            <h2>Login</h2>
            <form method="post" action="/jogar">
                <label>Email <input type="text" name="email"/></label>
                <label>Senha <input type="password" name="senha"/></label>
                <input type="submit" className="btn form-submit" value="Entrar"/>
                <div className="links-cadastro"><Link to="#">Esqueceu a senha?</Link> <br/><Link to="/cadastro">Cadastrar</Link></div>
            </form>
        </div>
        
        )
    }
}

export default Login;