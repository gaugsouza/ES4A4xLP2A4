Scenario: Login bem sucedido
Given Usuário na página de login
When Informar usuário e senha válidos
And Clicar no botão login
Then Usuário é direcionado para a página inical

Scenario: Login mal sucedido
Given Usuário na página de login
When Informar usuário ou senha inválidos
And Clicar no botão login
Then Usuário continua na mesma página 
And Usuário recebe um alerta de erro