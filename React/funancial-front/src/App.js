import React, {useState, useEffect} from 'react';
import './css/App.css';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import TelaInicial from './component/TelaInicial';
import Login from './component/Login';
import Cadastro from './component/Cadastro';
import Navbar from './component/Navbar';
import CadastroSucesso from './component/CadastroSucesso';

const App = ({history}) => {
  const [title, setTitle] = useState('');
  useEffect(()=>{
    document.title = `Funancial - ${title}`;
  })

  return (
    <div className="gameBG">
      <BrowserRouter>
        <Navbar title={title}/>
        <div className="app container">
          <Switch>
            <Route exact path="/">
                <TelaInicial setTitle={setTitle} />
            </Route>
            <Route path="/login">
                <Login setTitle={setTitle} />
            </Route>
            <Route path="/cadastro">
                <Cadastro setTitle={setTitle}/>
            </Route>
            <Route path="/cadastro-sucesso">
                <CadastroSucesso />
            </Route>
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
