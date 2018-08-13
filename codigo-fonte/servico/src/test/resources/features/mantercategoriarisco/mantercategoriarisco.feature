# language: pt
# encoding: utf-8

Funcionalidade: Manter Categoria do Risco

  @ManterCategoriaRisco
  Cenario: Critério 02: Incluir categoria de risco
    Dado que o usuário esteja em categoria de risco
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta o formulário para informar dados da categoria de risco

  @ManterCategoriaRisco
  Cenario: Critério 03: Concluir inclusão categoria de risco
    Dado que o usuário esteja em inclusão de categoria de risco
    E informou os parâmetros necessários
    Quando o usuário acionar a opção "Incluir"
    Então o sistema grava os dados
    E apresenta a mensagem "Registro salvo com sucesso."
    E adiciona o item salvo na lista

  @ManterCategoriaRisco
  Cenario: Critério 04: Validar dados existentes
    Dado que o usuário esteja em categoria de risco
    E informou dados de um item já existente
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta a mensagem "Registro já cadastrado."

  @ManterCategoriaRisco
  Cenário: Critério 11: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado categoria de risco
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar os campos que não foram preenchidos, em vermelho e apresentar as mensagens padrões

  @ManterCategoriaRisco
  Cenário: Critério 12: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado categoria de risco
    Quando o usuário acionar a opção "Limpar"
    Então o sistema limpa os dados informados