/*const FakeRest = require('fakerest');
const fetchMock = require('fetch-mock');
const {usuario} = require('../data');

const restServer = new FakeRest.FetchServer('http://localhost:3000/usuarios');
restServer.init(usuario);
// plug the restServer in front of fetch()
fetchMock.mock('^http://localhost:3000/usuarios', restServer.getHandler());
*/

const {usuario} = require('../data');
const  nock = require('nock');

const scope = nock('http://localhost:3000')
               .get('/usuarios')
               .reply(200, usuario);

const {Given, When, Then, AfterAll, setDefaultTimeout} = require('cucumber');
const {Builder, By, Capabilities, Key} = require('selenium-webdriver');
const  {expect} = require('chai');
setDefaultTimeout(4 * 5000);
require('chromedriver');
const capabilities = Capabilities.chrome();
capabilities.set('chromeOptions', {"w3c": false});

const driver = new Builder().withCapabilities(capabilities).build();


Given('Usuário está na {string}',async function (string) {
   await driver.get('http://localhost:3000');
   let title = await driver.getTitle();
   expect(title).to.equal('Funancial - Economy for Kids');
 });

 When('Clicar no botão com texto {string}',async function (string) {
   await driver.findElement(By.linkText(string)).click();
 });

 Then('{string} deve estar visível para ele',{timeout: 4*5000},async function (string) {
    let form = await driver.findElement(By.css('.form-container'));
    expect(form).to.not.undefined;
 });


 Given('Usuário na página de {string}',async function (string) {
   await driver.get('http://localhost:3000');
   await driver.findElement(By.linkText('Acessar')).click();
   await driver.findElement(By.linkText(string)).click();
 });

 When('Informar usuário e senha válidos', async function () {
    let scriptEmail = `document.forms[0].email.setAttribute('value', 'teste@teste.com');`;
    let scriptSenha = `document.forms[0].senha.setAttribute('value', 'teste1234');`;
   await driver.executeScript(scriptEmail);
   await driver.executeScript(scriptSenha);
 });


When('Clicar no botão do formulário de nome {string}', async function(string){
   nock('http://localhost:3000')
               .get('/usuarios')
               .reply(200, usuario);
   await driver.findElement(By.css('.form-container'))
         .findElement(By.name(string)).click()
});


 Then('Usuário é direcionado para a página inicial do {string}',{timeout: 4 * 5000}, async function (string) {
   const title = await driver.getTitle();
   expect(string).to.equal(title);

 });
/*


 AfterAll('end', async function(){
   await driver.close();
});
*/

/*beforeAll('inicio', async function(){

});*/


/*
Given('acessei a página inicial', async function () {
   await driver.get('http://localhost:3000/')
});

Then('devo ter como resposta página com título {string}',{timeout: 3 * 5000}, async function (string) {
   const title = await driver.getTitle();
   expect(title).to.equal(string);
});


AfterAll('end', async function(){
    await driver.quit();
});*/

//https://www.freecodecamp.org/news/testing-react-hooks/
//https://github.com/ionic-team/stencil/issues/1299
//https://stackoverflow.com/questions/46078530/jest-unit-testing-test-setstate