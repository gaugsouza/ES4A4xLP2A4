Feature: Login

Scenario: Login bem sucedido
Given Acessei "Login"
When Informar usuário e senha válidos
And Clico no botão submit
Then Sou redirecionado para "Tela Inicial"

Scenario: Login mal sucedido
Given Acessei "Login"
When Informar usuário ou senha inválidos
And Clico no botão submit
Then Mensagem de "erro" deve estar visível
And Devo permanecer na página "Login"

# Scenario: Tela Inicial usuário não logado
# Given Acessei "Tela Inicial"
# And Não estou logado
# Then elementos do jogo não devem ter ação em interação "Hover"

# Scenario: Tela Inicial usuário logado
# Given Acessei "Tela Inicial"
# And Estou logado
# Then elementos do jogo devem ter ação em interação "Hover"