# language: pt
# encoding: utf-8

Funcionalidade: ManterCalculadora

  @ManterCalculadora
  Cenario: Informar pesos do Aspectos Avaliativos
  Dado que o usuário esteja em menu do sistema
  Quando o usuário acionar a opção 'Calculadora'
  Então o sistema apresenta os parâmetros, com as opções 'Cancelar' e 'Gravar' conforme protótipo


  @ManterCalculadora
  Cenario: Salvar dados
    Dado que o usuário esteja em calculadora
    E selecionou o tipo de calculadora que deseja atualizar
    E informou parâmetros necessários
    Quando o usuário acionar a opção 'Gravar'
    E atualiza o dados na etapa "Avaliação de Risco e Controles"
    E apresenta a mensagem "Dados informados, salvos com sucesso!"


  @ManterCalculadora
  Cenario:Cancelar Operação
    Dado que o usuário esteja em calculadora
    Quando o usuário acionar a opção 'Cancelar'
    Então o sistema cancela operação.
    E retorna para a tela anterior.

