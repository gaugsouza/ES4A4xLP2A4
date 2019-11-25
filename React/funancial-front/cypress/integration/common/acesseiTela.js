import {Given}  from 'cypress-cucumber-preprocessor/steps';
import { getPath, getPageTitle } from '../../util/urlMap';


Given(`Acessei {string}`, (string) => {
    const path = getPath(string);
    const pageTitle = getPageTitle(string);
    cy.visit(path)
    cy.title().should('be', pageTitle);
});