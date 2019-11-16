import {When}  from 'cypress-cucumber-preprocessor/steps';
import * as autenticacaoUtils from '../../../src/util/autenticacao';
const usuarioMock = {
    email: "teste@teste.com.br",
    senha: "teste1234"
}

When('Informar usuário e senha válidos', () =>{
    cy.get('input[name="email"]').type(usuarioMock.email);
    cy.get('input[name="senha"]').type(usuarioMock.senha);
});

When('Informar usuário ou senha inválidos', () =>{
    cy.get('input[name="email"]').type(usuarioMock.email);
    cy.get('input[name="senha"]').type("lskjaddgdsg");
});


When('Clico no botão submit', () =>{
    cy.server()
    cy.route('POST', '/api/usuarios/login', {
        nome: 'teste',
        email: 'teste@teste.com.br',
        senha: 'teste1234'

    })

    cy.get('input[type="submit"]').click();

});