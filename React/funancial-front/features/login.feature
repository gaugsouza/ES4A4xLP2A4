Feature: Telaa de login

Scenario: Visualizando tela de Login
Given Usuário está na "Tela Inicial"
When Clicar no botão com texto "Acessar"
And Clicar no botão com texto "Login"
Then "Formulário de login" deve estar visível para ele

Scenario: Login bem sucedido
Given Usuário na página de "Login"
When Informar usuário e senha válidos
And Clicar no botão do formulário de nome "login"
Then Usuário é direcionado para a página inicial do "Jogo"

#Scenario: Login mal sucedido
#Given Usuário na página de login
#When Informar usuário ou senha inválidos
#And Clicar no botão login
#Then Usuário continua na mesma página 
#And Usuário recebe um alerta de erro