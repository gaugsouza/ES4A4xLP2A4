import React, { useEffect } from 'react';
import ElementosDeAcesso from './ElementosDeAcesso';
import GameUtils from './GameUtils';



const TelaInicial = ({setTitle, isLogado}) => {
    useEffect(() =>{
        setTitle("Economy for Kids");
        console.log(isLogado)
    });
    return(
        <div>
           { isLogado ? <GameUtils /> :<ElementosDeAcesso/> }           
        </div>
    )
};

export default TelaInicial;
