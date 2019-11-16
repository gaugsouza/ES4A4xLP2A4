Feature: Cadastro

Scenario: Cadastro bem sucedido
Given Acessei "Cadastro"
When Preencho todos os campos corretamente
And Clico no botão submit
Then Sou redirecionado para "Cadastro bem sucedido"

Scenario: Cadastro mal sucedido
Given Acessei "Cadastro"
When Preencho um ou mais campos de maneira incorreta
And Clico no botão submit
Then Mensagem de "erro" deve estar visível