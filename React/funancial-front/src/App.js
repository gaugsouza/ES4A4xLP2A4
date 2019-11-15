import React from 'react';
import './App.css';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import TelaInicial from './component/TelaInicial';
import Login from './component/Login';
import Cadastro from './component/Cadastro';
function App() {
  return (
    <BrowserRouter>
      <div className="aplicacao">
        <Switch>
          <Route exact path="/" component={TelaInicial}/>
          <Route path="/login" component={Login}/>
          <Route path="/cadastro" component={Cadastro}/>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
