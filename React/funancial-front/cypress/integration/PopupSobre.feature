Feature: Popup Sobre 

Scenario: Exibição com sucesso
Given Acessei "Tela Inicial"
When Clico no link com texto "Sobre"
Then Elemento "sobre" fica visível

Scenario: Exibição sem sucesso
Given Acessei "Tela Inicial"
When Clico no link com texto "Sobre"
Then Mensagem de "erro" deve estar visível