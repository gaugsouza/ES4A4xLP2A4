import React, { useEffect } from 'react';

const Cadastro = ({setTitle}) => {
    useEffect(() =>{
        setTitle('Cadastro');
    })
    return(
        <div className="cadastro">
            Cadastro
        </div>
    );
}
export default Cadastro;
