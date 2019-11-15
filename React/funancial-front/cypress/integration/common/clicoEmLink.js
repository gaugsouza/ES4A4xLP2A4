import {When} from 'cypress-cucumber-preprocessor/steps';

When(`Clico no link com texto {string}`, linkText =>{
    cy.contains(linkText).click();
});