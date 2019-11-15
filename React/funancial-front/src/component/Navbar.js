import React from 'react';
import { Link } from 'react-router-dom';
const Navbar = ({title}) => {
    return(
        <header className="header">
            <div className="container">
                <div><Link to="/">Funancial</Link> - {title}</div>
            </div>
        </header>
    );
};

export default Navbar;
