import {When}  from 'cypress-cucumber-preprocessor/steps';

const usuario = {
    nome : "Teste",
    email: "teste@teste.com.br",
    emailRepetido: "teste123@teste.com.br",
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

When('insiro e-mail já cadastrado', () =>{
    cy.get('input[name="nome"]').type(usuario.nome);
    cy.get('input[name="email"]').type(usuario.emailRepetido);
    cy.get('input[name="senha"]').type(usuario.senha);
    cy.get('input[name="confirmaSenha"]').type(usuario.senha);
});

When('Clico no botão submit', () =>{
    var usuarioAutenticado = {};
    const checkUsuario = (novoUsuario) => {
        if(novoUsuario.email === usuario.emailRepetido){
            throw new Error("E-mail já cadastrado");
        }
        return {data: novoUsuario};
    }

    cy.server();
    cy.route({
        method: 'POST',
        url: 'https://funancial-backend.herokuapp.com/login/cadastro',
        onRequest: (xhr) =>{
            let body = xhr.request.body;
            console.log(body)
            usuarioAutenticado = checkUsuario(body);
            console.log(usuarioAutenticado);
        },
        response: usuarioAutenticado
    });
    cy.get('input[type="submit"]').click();
});

