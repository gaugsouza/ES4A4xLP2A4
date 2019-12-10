import React, { useEffect } from 'react';
import ElementosDeAcesso from './ElementosDeAcesso';
import GameUtils from './GameUtils';
const TelaInicial = ({setTitle}) => {
    useEffect(() =>{
        setTitle("Economy for Kids");
    })
    return(
        <div>
            <GameUtils />
           <ElementosDeAcesso/>
        </div>
    )
};

export default TelaInicial;