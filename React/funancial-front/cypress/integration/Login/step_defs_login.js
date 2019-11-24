import {When}  from 'cypress-cucumber-preprocessor/steps';
import * as autenticacao from '../../../src/util/autenticacao';
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
   /* const validarUsuario = usuario =>{
        cy.log('usuario: ', usuario);
        let promise = new Promise((resolve, reject) =>{
            if(usuario.email === usuarioMock.email && usuario.senha === usuarioMock.senha){
                resolve({
                    data:usuario
                });
            }else{
                reject(new Error('Usuário ou senha incorretos'));
            }
        });
        return promise;
    }*/
    cy.server();cy.route({
        method: 'POST',
        url: '/api/usuarios/login',
        status: 200,
        onRequest: (xhr) =>{
            let {usuario} = xhr.request.body;
            if(usuario.email === usuarioMock.email && usuario.senha === usuarioMock.senha){
                return xhr;
            }else{
                throw new Error('Usuario ou senha incorretos');
            }
        },
        onResponse: (xhr) =>{
            return xhr;
        }
    });

    
    /*cy.stub(autenticacao, 'logarUsuario', (usuario) =>{
        let promise = new Promise((resolve, reject) =>{
            if(usuario.email === usuarioMock.email && usuario.senha === usuarioMock.senha){
                resolve({
                    data:usuario
                });
            }else{
                reject(new Error('Usuário ou senha incorretos'));
            }
        });
        return promise;
    });*/
    cy.get('input[type="submit"]').click();

});