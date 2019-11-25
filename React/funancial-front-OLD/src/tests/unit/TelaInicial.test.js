import React from "react";
import {render, unmountComponentAtNode } from 'react-dom';
import {act} from 'react-dom/test-utils';
import TelaInicial from  '../../Components/TelaInicial';
import {  BrowserRouter as Router} from 'react-router-dom';

let container = null;

beforeEach(()=>{
    container = document.createElement("div");
    document.body.appendChild(container);
});

afterEach(()=>{
    unmountComponentAtNode(container);
    container.remove();
    container = null;
});


it(`renders one button with text "Acessar"`, () =>{
    act(()=>{
        render(<Router><TelaInicial /></Router>, container);
    });
    let accessButton = container.querySelector('.acessar').textContent;

    expect(accessButton).toBe('Acessar');
    
});

it(`renders one button with text "Login"`, () =>{
    act(()=>{
        render(<Router><TelaInicial /></Router>, container);
    });
    let accessButton = container.querySelector('.login').textContent;

    expect(accessButton).toBe('Login');
    
});

it(`renders one button with text "Cadastro"`, () =>{
    act(()=>{
        render(<Router><TelaInicial /></Router>, container);
    });
    let accessButton = container.querySelector('.cadastro').textContent;

    expect(accessButton).toBe('Cadastro');
    
});