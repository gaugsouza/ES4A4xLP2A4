import Sobre from './Components/Sobre';
import Cadastro from './Components/Cadastro';
import Login from './Components/Login';
import Estatisticas from './Components/Estatisticas';
import Jogo from './Components/Jogo';
import TelaInicial from './Components/TelaInicial';
import React, { Component } from 'react';
import './App.css';
import {  BrowserRouter, Route, Switch } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div className="App gameBg">
          <TelaInicial/>
          <Switch>
            <Route exact path='/' component={TelaInicial} />
            <Route path='/jogo' component={Jogo} />
            <Route path='/cadastro' component={Cadastro} />
            <Route path='/login' component={Login} />
            <Route path='/estatisticas' component={Estatisticas} />
            <Route path='/sobre' component={Sobre} />
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
