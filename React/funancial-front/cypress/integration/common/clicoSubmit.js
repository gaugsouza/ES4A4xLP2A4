import {When}  from 'cypress-cucumber-preprocessor/steps';

When('Clico no botão submit', () =>{
    cy.get('input[type="submit"]').click();
})