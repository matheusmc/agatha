# language: pt
# encoding: utf-8

Funcionalidade: Manter Controle


#cenario 2
@ManterOperacaoControle
Cenario: Incluir Operação de Controle
  Dado que o usuário esteja em desenho de Operação de controle de risco
  Quando o usuário acionar a opção "Incluir"
  Então o sistema apresenta o formulário para informar dados do Operação de Controle

#cenario 11
  @ManteroperacaoControle
  Cenario: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado Operação de Controle
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões

     #cenario 12
  @ManterControle
  Cenario: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado Operação de Controle
    Quando o usuário acionar a opção 'Limpar'
    Então o sistema limpa os dados informados









