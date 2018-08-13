# language: pt
# encoding: utf-8

Funcionalidade: Manter Natureza do Risco

  @NaturezaRisco
  Cenário: Critério 02: Incluir natureza de risco
    Dado que o usuário esteja em natureza de risco
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta o formulário para informar dados da natureza de risco

  @NaturezaRisco
  Cenário: Critério 05: Alterar natureza de risco
    Dado que o usuário esteja em lista de natureza de risco salvos
    Quando o usuário acionar a opção "Alterar" no item desejado
    Então o sistema apresenta os dados para serem alterados

  @NaturezaRisco
  Cenário: Critério 11: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado natureza de risco
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões

  @NaturezaRisco
  Cenário: Critério 12: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado natureza de risco
    Quando o usuário acionar a opção "Limpar"
    Então o sistema limpa os dados informados