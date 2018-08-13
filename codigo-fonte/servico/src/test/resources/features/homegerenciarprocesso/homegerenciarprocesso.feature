# language: pt
# encoding: utf-8

Funcionalidade: US003 Home Gerenciar Processo – Para todos os Perfis

  @HomeGerenciarProcesso
  Cenário: Critério 01: Apresentar opção conforme permissão
    Dado que o usuário efetuou a autenticação no sistema
    Quando o sistema apresentar a lista dos macroprocesso/processo
    Então o sistema deve apresentar as opção de ações do usuário, conforme as permissões do perfil logado

  @HomeGerenciarProcesso
  Cenario: Critério 02: Incluir novo mapeamento de risco
    Dado que o usuário esteja lista de macroprocesso/processos de risco
    Quando o usuário acionar a opção Incluir
    Então o sistema apresenta a funcionalidade US004 Formulário de Levantamento de Informações sobre Ambiente e sobre a Fixação de Objetivos

  @HomeGerenciarProcesso
  Cenario: Critério 03: Visualizar Etapa
    Dado que o usuário esteja lista de macroprocesso/processos de risco
    Quando o usuário acionar a opção Visualizar
    Então o sistema apresenta a etapa selecionada para visualização com as opções Voltar e Imprimir

  @HomeGerenciarProcesso
  Cenario: Critério 04: Alterar Etapa
    Dado que o usuário esteja em lista de macroprocesso/processos de risco
    Quando o usuário acionar a opção Alterar em uma etapa desejada
    Então o sistema apresenta o formulário da etapa selecionada para alteração

  @HomeGerenciarProcesso
  Cenario: Critério 05: Validar Etapa
    Dado que o usuário esteja em lista de macroprocesso/processos de risco
    Quando o usuário acionar a opção Validar
    Então o sistema apresenta o formulário selecionado para a validação
#    Obs: Após a validação da etapa o ícone check deve ficar em cor verde.

  @HomeGerenciarProcesso
  Cenario: Critério 06: Status do Processo Em andamento
    Dado que o usuário esteja em lista de macroprocesso/processos de risco
    Quando o usuário gestor, validar algumas das etpas do processo
    Então o sistema apresenta a label do macroprocesso/processo em cor amarela

  @HomeGerenciarProcesso
  Cenario: Critério 07: Status do Processo Finalizado
    Dado que o usuário esteja em lista de macroprocesso/processos de risco
    Quando o usuário gestor, validar todas as etapas do processo
    Então o sistema apresenta a label do macroprocesso/processo em cor verde