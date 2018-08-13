# language: pt
# encoding: utf-8
Funcionalidade: Formulário de Levantamento de Informações sobre Ambiente e sobre a Fixação de Objetivos
#
  @FormularioLevantamento
  Cenario: formulário de Analise de Ambiente e de Fixação de Objetivos
    Dado que o usuário esteja em formulário de Analise de Ambiente e de Fixação de Objetivos
    E preencheu todos os parâmetros necessários para o cadastro
    Quando o usuário acionar a opção 'Gravar' sem pendências
    Então o sistema grava os dados informados
    E apresenta a mensagem "Registro salvo com sucesso."
    E alterar o status da etapa para 'Iniciada'

  @FormularioLevantamento
  Cenario: Cancelar operação
    Dado que o usuário esteja em formulário de Analise de Ambiente e de Fixação de Objetivos
    Quando o usuário acionar a opção 'Cancelar'
    Então o sistema cancela operação
    E retorna para a tela anterior

  @FormularioLevantamento
  Cenario: Incluir Item SWOT
    Dado que o usuário esteja em formulário de Analise SWOT
    E informou os parâmetros necessários
    Quando o usuário acionar a opção 'Adicionar'
    Então o sistema grava os dados

  @FormularioLevantamento
  Cenario: Validação de campos Obrigatórios
    Dado que o usuário esteja em formulário de Analise de Ambiente e de Fixação de Objetivos
    Quando o usuário acionar a opção 'Gravar'e ou 'Enviar para validação' sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões
