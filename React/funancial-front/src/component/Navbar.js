import React from 'react';
import { Link } from 'react-router-dom';
const Navbar = ({title}) => {
    let titleRender = title !== ''&& title !== undefined ? title : `Economy for Kids`;
    return(
        <header className="header">
            <div className="container">
                <div><Link to="/">Funancial</Link> - {titleRender}</div>
            </div>
        </header>
    );
};

export default Navbar;
