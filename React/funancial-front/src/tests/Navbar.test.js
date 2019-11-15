import React from 'react';

import Navbar from '../component/Navbar';
import { act } from "react-dom/test-utils";
import { render, unmountComponentAtNode } from "react-dom";
import {BrowserRouter as Router} from 'react-router-dom';

let container = null;
beforeEach(()=>{
  container = document.createElement('div');
  document.body.appendChild(container);
});

afterEach(() => {
  unmountComponentAtNode(container);
  container.remove();
  container = null;
});


  it(`Deve renderizar com o texto "Funancial - Economy for Kids`, () =>{
    act(()=>{
      render(<Router><Navbar/></Router>, container);
    });
    expect(container.querySelector(".header .container div").textContent).toBe('Funancial - Economy for Kids');
  });

  it(`Deve renderizar com o texto "Funancial - teste`, () =>{
    act(()=>{
      render(<Router><Navbar title="teste"/></Router>, container);
    });
    expect(container.querySelector(".header .container div").textContent).toBe('Funancial - teste');
  })