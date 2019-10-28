import React, { Component } from 'react';

const Perfil = ({usuario}) =>{
    return(
        <div>
            <p>{usuario.nome}</p>
            <p>{usuario.email}</p>
        </div>
    );
}
/*
class Perfil extends Component{
    render(){
        return(<p>Perfil</p>);
    }
}*/

export default Perfil;