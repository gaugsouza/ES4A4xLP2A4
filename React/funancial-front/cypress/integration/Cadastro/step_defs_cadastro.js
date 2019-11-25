import {When}  from 'cypress-cucumber-preprocessor/steps';

const usuario = {
    nome : "Teste",
    email: "teste@teste.com.br",
    senha: "teste1234",
    senhaErrada: "teste12345"
}

When('Preencho todos os campos corretamente', () =>{
    cy.get('input[name="nome"]').type(usuario.nome);
    cy.get('input[name="email"]').type(usuario.email);
    cy.get('input[name="senha"]').type(usuario.senha);
    cy.get('input[name="confirmaSenha"]').type(usuario.senha);
});

When('Preencho um ou mais campos de maneira incorreta', () =>{
    cy.get('input[name="nome"]').type(usuario.nome);
    cy.get('input[name="email"]').type(usuario.email);
    cy.get('input[name="senha"]').type(usuario.senha);
    cy.get('input[name="confirmaSenha"]').type(usuario.senhaErrada);
});

When('Não preencho um dos campos obrigatórios', () =>{
    cy.get('input[name="email"]').type(usuario.email);
    cy.get('input[name="senha"]').type(usuario.senha);
    cy.get('input[name="confirmaSenha"]').type(usuario.senhaErrada);
});

When('Clico no botão submit', () =>{
    cy.server();
    cy.route('POST', '/usuario/', usuario);
    cy.get('input[type="submit"]').click();
});