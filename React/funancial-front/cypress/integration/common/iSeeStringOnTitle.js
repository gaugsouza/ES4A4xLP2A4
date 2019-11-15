import { Then } from "cypress-cucumber-preprocessor/steps";

Then(`I see {string} in the title`, (title) =>{
    cy.title().should('include', title);
})

Then(`Devo ver {string} no titulo`, (title) =>{
    cy.title().should('include', title);
})