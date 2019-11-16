import {Then}  from 'cypress-cucumber-preprocessor/steps';
import { getPath } from '../../util/urlMap';

let url = 'http://localhost:3000';
Then('Sou redirecionado para {string}', pathParam =>{
    let path = getPath(pathParam);
    cy.url().should('eq', `${url}/${path}`);
})