Feature: Popup Tela do Usuário

Scenario: Exibição com sucesso
Given Acessei "Tela Inicial"
When Clico no botão com texto "Perfil"
Then Elemento "Perfil" fica visível

Scenario: Exibição sem sucesso
Given Acessei "Tela Inicial"
When Clico no botão com texto "Perfil"
Then Mensagem de "erro" deve estar visível

Scenario: Alterar avatar
Given Acessei "Perfil"
When Clico no link com texto "Mudar o avatar"
Then Mensagem de "sucesso" deve estar visível

Scenario: Alterar nome
Given Acessei "Perfil"
When Digito nome na caixa "Nome"
And Clico no link com texto "Alterar"
Then Mensagem de "sucesso" deve estar visível

Scenario: Sair
Given Acessei "Perfil"
When Clico no botão com texto "Sair"
Then Sou redirecionado para "Tela Inicial"