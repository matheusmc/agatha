# language: pt
# encoding: utf-8

Funcionalidade: US015 Manter Causas de Eventos de Risco

  @ManterCausasEventosRisco
  Cenario: Critério 12: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado Causas de Eventos de Risco
    Quando o usuário acionar a opção "Limpar"
    Então o sistema limpa os dados informados

  @ManterCausasEventosRisco
  Cenario: Critério 11: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado Causas de Eventos de Risco
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar os campos que não foram preenchidos, em vermelho e apresentar as mensagens padrões

  @ManterCausasEventosRisco
  Cenario: Critério 02: Incluir Causa de Evento de Risco
    Dado que o usuário esteja em causa de evento de risco
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta o formulário para informar dados da causa do evento de risco