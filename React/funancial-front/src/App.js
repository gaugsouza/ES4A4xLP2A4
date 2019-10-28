import Sobre from './Components/Sobre';
import Cadastro from './Components/Cadastro';
import Login from './Components/Login';
import Estatisticas from './Components/Estatisticas';
import Jogo from './Components/Jogo';
import TelaInicial from './Components/TelaInicial';
import Perfil from './Components/Perfil'
import React, { Component } from 'react';
import './App.css';
import {  BrowserRouter, Route, Switch } from 'react-router-dom';
import CadastroSucesso from './Components/CadastroSucesso';

class App extends Component {
  state = {
    //Depois essa informação vai vir do banco
    usuarios:[],
    usuarioLogado:{}
  }
  addUsuario  = usuario =>{
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
    })
  }
  render() {
    return (
      <BrowserRouter>
        <div className="App gameBg">
          <Switch>
            <Route exact path='/' render={(props)=>(<TelaInicial {...props} usuarioLogado={this.state.usuarioLogado}/>)} />
            <Route path='/jogar' component={Jogo} />

            <Route path='/cadastro' 
                render={(props) =>
                (<Cadastro {...props} addUsuario={this.addUsuario}/>)} />

            <Route path='/login' 
                render={(props) =>(<Login {...props} usuarios={this.state.usuarios} logar={this.logar}/>)} />

            <Route path='/estatisticas' component={Estatisticas} />
            <Route path='/sobre' component={Sobre} />
            <Route path='/perfil/:id' render={(props) =>(<Perfil {...props} usuario={this.state.usuarioLogado}/>)} />
            <Route path='/cadastroSucesso' component={CadastroSucesso} />
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
