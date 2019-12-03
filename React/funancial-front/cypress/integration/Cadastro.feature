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
And Devo permanecer na página "Cadastro"

Scenario: Cadastro mal sucedido por campo não preenchido
Given Acessei "Cadastro"
When Não preencho um dos campos obrigatórios
And Clico no botão submit
Then Mensagem de "erro" deve estar visível
And Devo permanecer na página "Cadastro"

Scenario: Cadastro mal sucedido por e-mail já cadastrado
Given Acessei "Cadastro"
When insiro e-mail já cadastrado
And Clico no botão submit
Then Mensagem de "erro" deve estar visível
And Devo permanecer na página "Cadastro"