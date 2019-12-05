import {Then}  from 'cypress-cucumber-preprocessor/steps';

Then('Mensagem de {string} deve estar visível', classMsg =>{
    cy.get(`.${classMsg}`).should('not.be.empty');
})

Then('Elemento {string} fica visível', pathParam =>{
    let path = getPath(pathParam);
    cy.url().should('eq', `${url}/${path}`);
})