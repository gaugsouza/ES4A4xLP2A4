import Sobre from './Components/Sobre';
import Estatisticas from './Components/Estatisticas';
import Jogo from './Components/Jogo';
import TelaInicial from './Components/TelaInicial';
import Perfil from './Components/Perfil';
import CadastroSucesso from './Components/CadastroSucesso';
import NotFound from './Components/NotFound';

import React, { Component } from 'react';
import './App.css';
import {  BrowserRouter, Route, Switch } from 'react-router-dom';


class App extends Component {
  state = {
    //Depois essa informação vai vir do banco
    usuarios:[],
    usuarioLogado:{}
  }
  addUsuario  = usuario =>{
    // Mudar isso para requisição para API
    usuario.id = Math.floor(Math.random()*999999999);
    let usuarios = [...this.state.usuarios, usuario];
    this.setState({
      usuarios
    });
    console.log(this.state.usuarios);
  }
  logar = usuario =>{
    this.setState({
      usuarioLogado:usuario
    });
  }
  render() {
    return (
      <BrowserRouter>
        <div className="App">
            <Switch>
              <Route exact path='/' render={(props)=>(<TelaInicial {...props} usuarioLogado={this.state.usuarioLogado} 
                                                        addUsuario={this.addUsuario} logar={this.logar} usuarios={this.state.usuarios} />)} />
              <Route path='/estatisticas' component={Estatisticas} />
              <Route path='/cadastroSucesso' component={CadastroSucesso} />
              <Route path='/perfil/:id' render={(props) =>(<Perfil {...props} usuario={this.state.usuarioLogado}/>)} />
              <Route path='/sobre' component={Sobre} />
              <Route path='/jogar' component={Jogo} />
              <Route component={NotFound} />
            </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
