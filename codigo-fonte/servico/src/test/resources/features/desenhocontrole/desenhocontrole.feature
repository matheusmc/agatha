# language: pt
# encoding: utf-8

Funcionalidade: Manter Desenho de Controle

  @DesenhoDeControle
  Cenário: Critério 02: Incluir Desenho de Controle
    Dado que o usuário esteja em desenho de controle de risco
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta o formulário para informar dados do Desenho de Controle

  @DesenhoDeControle
  Cenário: Critério 11: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado Desenho de Controle
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões

  @DesenhoDeControle
  Cenário: Critério 12: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado Desenho de Controle
    Quando o usuário acionar a opção "Limpar"
    Então o sistema limpa os dados informados