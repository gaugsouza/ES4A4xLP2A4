import React from 'react';
import {Link} from 'react-router-dom';

const CadastroForm = ({handleSubmit, handleChange, errMsg}) =>{
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
    );
}

export default CadastroForm;



