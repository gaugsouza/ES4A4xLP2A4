const {Given, When, Then, AfterAll, setDefaultTimeout} = require('cucumber');
const {Builder, By, Capabilities, Key} = require('selenium-webdriver');
const {expect} = require('chai');
setDefaultTimeout(2 * 5000);
require('chromedriver');

// Config driver
const capabilities = Capabilities.chrome();
capabilities.set('chromeOptions', {"w3c": false});

const driver = new Builder().withCapabilities(capabilities).build();
/*
Given('I am on the Google search page', async function () {
    await driver.get('http://www.google.com');
});

When('I search for {string}', async function (busca) {
    const element = await driver.findElement(By.name('q'));
    element.sendKeys(busca, Key.RETURN);
    element.submit();
});


Then('the page title should start with {string}', {timeout: 3 * 5000}, async function (searchTerm) {
    const title = await driver.getTitle();
    const isTitleStartWithCheese = title.toLowerCase().lastIndexOf(`${searchTerm}`, 0) === 0;
    expect(isTitleStartWithCheese).to.equal(true);
});
AfterAll('end', async function(){
    await driver.quit();
});*/

Given('estou na página inicial da aplicação', async function () {
    await driver.get('localhost:3000/');
});

Then('devo receber uma página', function () {
    // Write code here that turns the phrase above into concrete actions
    //TODO
});

AfterAll('end', async function(){
    await driver.quit();
});