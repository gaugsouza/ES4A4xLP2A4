import React from 'react';
import { Link } from 'react-router-dom';
const MenuLateral = ({usuarioLogado}) =>{

    return (
        <ul className="menu-direita">
            <li><Link to={"/perfil/"+usuarioLogado.id} className="btn perfil">Perfil</Link></li>
            <li><Link to="/estatisticas" className="btn estatisticas">Estatísticas</Link></li>  
        </ul>
    );
}

export default MenuLateral;