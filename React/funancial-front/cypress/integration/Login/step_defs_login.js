import {When}  from 'cypress-cucumber-preprocessor/steps';
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

When('Não informo um dos campos obrigatórios', () =>{
    cy.get('input[name="email"]').type(usuarioMock.email);
});


When('Clico no botão submit', () =>{
    var usuarioAutenticado = {};
    const checkUsuario = usuario => {
        if(usuario.email === usuarioMock.email && usuario.senha === usuarioMock.senha){
            return {data:usuario}
        }else{
            throw new Error('Email ou senha incorretos');
        }
    }
    cy.server();
    cy.route({
            method: 'POST',
            url: '/api/usuarios/login',
            onRequest: (xhr) =>{
                let body = xhr.request.body;
                console.log(body)
                usuarioAutenticado = checkUsuario(body);
                console.log(usuarioAutenticado);
            },
            response: usuarioAutenticado
        })

    cy.get('input[type="submit"]').click();

});