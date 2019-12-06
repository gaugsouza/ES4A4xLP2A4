import React from 'react';
import { Link } from 'react-router-dom';
const CadastroSucesso = () => {
    return(
        <div className="container cadastro-sucesso">
            <h4>Obrigado por se cadastrar em</h4>
            <h2>FUNancial - Economy for Kids</h2>
            <p>Infelizmente, no momento, o jogo não está pronto, mas seus dados ficarão guardados e quando tudo estiver perfeito entraremos em contato para que você possa se divertir de montão!</p>
            <Link to="/">Voltar para a home</Link>
        </div>
    )
}



export default CadastroSucesso;