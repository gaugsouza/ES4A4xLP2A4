import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../../public/logo.jpg'
import '../CSS/Navbar.css';
import MenuLateral from './MenuLateral';

const Navbar = ({usuarioLogado}) =>{
    let menuLateral = usuarioLogado.id !== undefined ?
        (<MenuLateral usuarioLogado={usuarioLogado}/>):(<div></div>)
    return(
        <nav className="navbar">
            <Link to="/" className="brand-logo"><img src={logo} alt="logo-funancial"/></Link>
            {menuLateral}
           
        </nav>
    )
}


export default Navbar;