import {Then}  from 'cypress-cucumber-preprocessor/steps';

Then('Elemento {string} fica visível', string =>{
    cy.get(`.${string}`).should("be.visible");
});