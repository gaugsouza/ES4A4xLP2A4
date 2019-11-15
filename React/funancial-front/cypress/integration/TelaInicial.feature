Feature: Tela Inicial

Scenario: Acessar página inicial
Given Acessei "Tela Inicial"
Then Devo ver "Funancial - Economy for Kids" no titulo 

Scenario: Acessar página de login
Given Acessei "Login"
When Clico no link com texto "Login"
Then Devo ver "Funancial - Login" no titulo 


Scenario: Acessar página de cadastro
Given Acessei "Cadastro"
When Clico no link com texto "Cadastro"
Then Devo ver "Funancial - Cadastro" no titulo 