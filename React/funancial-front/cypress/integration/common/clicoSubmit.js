import {When}  from 'cypress-cucumber-preprocessor/steps';

When('Clico no botão submit', () =>{
    cy.get('input[type="submit"]').click();
})

When ('Clico no botão com texto {string}', (string) =>{
    cy.get(string).click();
})