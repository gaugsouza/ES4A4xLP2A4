import {Given}  from 'cypress-cucumber-preprocessor/steps';
import { getPath, getPageTitle } from '../../util/urlMap';

const url = 'http://localhost:3000';
Given(`Acessei {string}`, (string) => {
    const path = getPath(string);
    const pageTitle = getPageTitle(string);
    cy.visit(`${url}/${path}`)
    cy.title().should('be', pageTitle);
});