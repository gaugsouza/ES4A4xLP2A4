import {Given}  from 'cypress-cucumber-preprocessor/steps';
import { getPath } from '../../util/urlMap';

const url = 'http://localhost:3000';
Given(`Acessei {string}`, (string) => {
    const path = getPath(string);
    cy.visit(`${url}/${path}`)
})