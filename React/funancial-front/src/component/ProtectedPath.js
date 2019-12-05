import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { withRouter } from 'react-router-dom';
import Estatistica from './Estatistica';
import Calendario from './Calendario';
import Jogo from './Jogo';
import Perfil from './Perfil';

const ProtectedPath = () =>{
    return(
        <Switch>
            <Route path="/estatisticas">
                <Estatistica /> 
            </Route>
            <Route path="/calendario">
                <Calendario />
            </Route>
            <Route path="/jogo">
                <Jogo />
            </Route>
            <Route path="/perfil">
                <Perfil />
            </Route>
        </Switch>
    );
}


export default withRouter(ProtectedPath);