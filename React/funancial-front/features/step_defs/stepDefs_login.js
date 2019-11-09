const {Given, When, Then, AfterAll, setDefaultTimeout, BeforeAll} = require('cucumber');
const {Builder, By, Capabilities, Key} = require('selenium-webdriver');
const  {expect} = require('chai');
setDefaultTimeout(3 * 5000);
require('chromedriver');
const capabilities = Capabilities.chrome();
capabilities.set('chromeOptions', {"w3c": false});

const driver = new Builder().withCapabilities(capabilities).build();

beforeAll('inicio', async function(){

});



Given('acessei a página inicial', async function () {
   await driver.get('http://localhost:3000/')
});

Then('devo ter como resposta página com título {string}',{timeout: 3 * 5000}, async function (string) {
   const title = await driver.getTitle();
   expect(title).to.equal(string);
});


AfterAll('end', async function(){
    await driver.quit();
});

//https://www.freecodecamp.org/news/testing-react-hooks/
//https://github.com/ionic-team/stencil/issues/1299
//https://stackoverflow.com/questions/46078530/jest-unit-testing-test-setstate