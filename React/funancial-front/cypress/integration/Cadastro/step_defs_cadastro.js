import {When}  from 'cypress-cucumber-preprocessor/steps';

When('Preencho todos os campos corretamente', () =>{
    cy.get('input[name="nome"]').type('Teste');
    cy.get('input[name="email"]').type('teste@teste.com.br');
    cy.get('input[name="senha"]').type('teste1234');
    cy.get('input[name="confirmaSenha"]').type('teste1234');
})

When('Preencho um ou mais campos de maneira incorreta', () =>{
    cy.get('input[name="nome"]').type('Teste');
    cy.get('input[name="email"]').type('teste@teste.com.br');
    cy.get('input[name="senha"]').type('teste1234');
    cy.get('input[name="confirmaSenha"]').type('teste12345');
})

When('Clico no botão submit', () =>{
    cy.server();
    cy.route('POST', '/api/usuarios/cadastro', true);
    cy.get('input[type="submit"]').click();
})