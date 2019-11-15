import React from 'react';
import { Link } from 'react-router-dom';
const CadastroSucesso = () =>{
    return(
        <div>
            <p>Cadastro realizado com sucesso</p>
            <Link to='/login' onClick={()=>{document.getElementsByClassName('login')[0].click();}}>Acessar jogo agora</Link>
        </div>
    )
}
export default CadastroSucesso;