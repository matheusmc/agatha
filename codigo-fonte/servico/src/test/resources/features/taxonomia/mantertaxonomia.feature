# language: pt
# encoding: utf-8

Funcionalidade: US026 Manter Taxonomia

  @ManterTaxonomia
  Cenario: Critério 01: Menu Taxonomia
    Dado que o usuário esteja em menu do sistema
    Quando o usuário acionar a opção Taxonomia
    Então o sistema apresenta os parâmetros para consulta, acrescido das opções Limpar e Consultar
    E apresenta a lista de sugestão de taxonomia recebida com as opções Selecionar, Consultar Agrupamento, Aprovar, Recusar e Agrupar, conforme protótipo

  @ManterTaxonomia
  Cenario: Critério 04: Consultar Agrupamento
    Dado que o usuário esteja em consulta de sugestão de taxonomia
    Quando o usuário acionar a opção Consultar Agrupamento
    Então o sistema apresenta os parâmetros para consulta, acrescido das opções Limpar e Consultar, conforme protótipo

  @ManterTaxonomia
  Cenario: Critério 10: Cancelar Operação
    Dado que o usuário esteja sugestões de taxonomia
    Quando o usuário acionar a opção Cancelar
    Então o sistema cancela operação
    E retorna para a tela anterior

