import React, {useState, useEffect} from 'react';
import './css/App.css';
import {BrowserRouter, Route, Switch, Redirect} from 'react-router-dom';
import TelaInicial from './component/TelaInicial';
import Login from './component/Login';
import Cadastro from './component/Cadastro';
import Navbar from './component/Navbar';
import CadastroSucesso from './component/CadastroSucesso';
import ProtectedPath from './component/ProtectedPath';
import NotFound from './component/NotFound';
import {checkUserLogado} from './util/checkUser';
const App = ({history}) => {
  const [title, setTitle] = useState('');
  let isLogado = checkUserLogado();

  useEffect(()=>{
    document.title = `Funancial - ${ title || "Economy for Kids" }`;
  });

  return (
    <div className="gameBG">
      <BrowserRouter>
        <Navbar title={title}/>
        <div className="app container">
          <Switch>
            <Route exact path="/">
                <TelaInicial isLogado={isLogado} setTitle={setTitle} />
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
            <Route path={["/estatisticas", "/calendario","/jogo","/perfil"]}>
               { isLogado ? <ProtectedPath /> : <Redirect to="/"/> }
            </Route>
            <Route component={NotFound}/>
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
