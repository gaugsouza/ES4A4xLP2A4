import React, {useState, useEffect} from 'react';
import {withRouter} from 'react-router-dom';
import { saveUser } from '../util/autenticacao';
import { Link } from 'react-router-dom';
import { nullKeyValidator } from '../util/nullKeyValidator'
import { verificarSenhas } from '../util/validaInfos'
const Cadastro = ({setTitle, history}) => {
    useEffect(() =>{
        setTitle('Cadastro');
    })
    const [usuario, setUsuario] = useState({
        nome:null,
        email:null,
        senha:null,
        confirmaSenha:null
    });

    const[mensagemErro, setMensagemErro] = useState(null);

    const handleChange = e =>{
        setUsuario({
            ...usuario,
            [e.target.name]:e.target.value
        })
    }

    
    const handleSubmit = e =>{
        try{
            e.preventDefault();
            nullKeyValidator(usuario);
            let {senha, confirmaSenha} = usuario;
            verificarSenhas(senha, confirmaSenha);
            let userACadastrar = {nome: usuario.nome, email: usuario.email, senha: senha}
            saveUser(userACadastrar)
            .then(({data}) =>{
                console.log(data);
                history.push("/cadastro-sucesso");
            })
            .catch(error =>{
                console.log(error);
                setMensagemErro(error.message);
            })
        }catch(e){
            setMensagemErro(e.message);
        }        
    }

    return(
        <div className="cadastro-form form-container">
            <h3>Cadastro</h3>
            <form method="POST" onSubmit={handleSubmit}>
                <label>
                    <span>Nome: </span>
                    <input type="text" name="nome" onChange={handleChange} />
                </label>
                <label>
                    <span>E-mail:</span>
                    <input type="email" name="email" onChange={handleChange}/>
                </label>
                <label>
                    <span>Senha:</span>
                    <input type="password" name="senha" onChange={handleChange}/>
                </label>
                <label>
                    <span>Confirme sua senha:</span>
                    <input type="password" name="confirmaSenha" onChange={handleChange}/>
                </label>
                <span className="erro">{mensagemErro}</span>
                <input type="submit" name="enviar" value="Cadastrar"/>
            </form>
            <div className="links-uteis">
                <Link to="login">Já sou cadastrado</Link>
            </div>
        </div>
    );
};

export default withRouter(Cadastro);
