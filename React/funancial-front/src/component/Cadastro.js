import React, {useState, useEffect} from 'react';
import {withRouter} from 'react-router-dom';

const Cadastro = ({addUsuario, setTitle, history}) => {
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
        e.preventDefault();
        for(let key in usuario){
            if(usuario[key] === null && key !== 'confirmaSenha'){
                setMensagemErro(`Campo de ${key.charAt(0).toUpperCase() + key.slice(1)} não pode ser nulo`);
                return false;
            }
        }
        let {senha, confirmaSenha} = usuario;

        if(senha !== confirmaSenha){
            setMensagemErro('Senhas não correspondem');
            return false;
        }

        addUsuario(usuario);
        history.push('/cadastro-sucesso');
    }

    return(
        <div className="cadastro-form">
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
        </div>
    );
};

export default withRouter(Cadastro);
