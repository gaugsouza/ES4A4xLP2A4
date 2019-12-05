import {When}  from 'cypress-cucumber-preprocessor/steps';

When('Digito na caixa {string}', pathParam =>{
    cy.get(pathParam);
})