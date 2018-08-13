# language: pt
# encoding: utf-8

Funcionalidade:Calcular Risco Inerente

  @CalcularRiscoInerente
  Cenário: Informar pesos do Aspectos Avaliativos
    Dado que o usuário esteja em calculadora de calculo de risco inerente
    Quando informar os pesos de cada aspecto avaliativo
    Então o sistema calcula automaticamente o total dos pesos informados Regra de Negócio "003 Calculo de Risco Inerente"

