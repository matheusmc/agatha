# language: pt
# encoding: utf-8

Funcionalidade: US016 Manter Consequencia de Evento de Risco

  Como usuário autenticado no sistema, com o perfil núcleo
  Preciso consultar, incluir, alterar e excluir Consequencia de Evento de Risco
  Para utilizar os dados na funcionalidade identificação de consequencias de eventos de risco

  Cenário: Critério 01: Menu Consequencia de Evento de Risco
    Dado que o usuário esteja em menu do sistema
    Quando o usuário acionar a opção "Consequencia de Evento de Risco"
    Então o sistema apresenta os parâmetros para consulta, acrescido das opções 'Limpar', 'Consultar' e 'Novo'
    E apresenta a lista de consequencia de eventos de riscos que foram cadastrados anteriormente com as opções 'Alterar', 'Ativar/Inativar' e 'Excluir', ordenado alfabeticamente pela coluna Descrição do Evento

  Cenário: Critério 02: Incluir Consequencia de Evento de Risco
    Dado que o usuário esteja em consequencia de evento de risco
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta o formulário para informar dados do consequencia de evento de risco

  Cenário: Critério 03: Concluir inclusão e consequencia de evento de risco
    Dado que o usuário esteja em consequencia de evento de risco
    E informou os parâmetros necessários
    Quando o usuário acionar a opção "Incluir"
    Então o sistema grava os dados
    E adiciona o item salvo na lista
    E apresenta a mensagem "Registro salvo com sucesso."

  Cenário: Critério 04: Validar dados existentes
    Dado que o usuário esteja em consequencia de evento de risco
    E informou dados de um item já existente
    Quando o usuário acionar a opção 'Incluir'
    Então o sistema apresenta a mensagem "Registro já cadastrado."

  Cenário: Critério 05: Alterar Consequencia de Evento de Risco
    Dado que o usuário esteja em lista de Consequencias de Eventos de Risco salvos
    Quando o usuário acionar a opção "Alterar" no item desejado
    Então o sistema apresenta os dados para serem alterados

  Cenário: Critério 06: Confirmando alteração
    Dado que o usuário esteja alterando dados do consequencia de evento de risco
    E informou os parâmetros necessários
    Quando o usuário acionar a opção "Alterar"
    Então o sistema apresenta a mensagem "Registro alterado com sucesso!"

  Cenário: Critério 07: Ativar Consequencia de Evento de Risco
    Dado que o usuário esteja em lista de Consequencias de Eventos de Risco
    Quando o usuário acionar a opção "Ativar" de um item que esteja inativado
    Então o sistema ativa o Consequencia de Evento de Risco selecionado
    E fica disponível para a vinculação a uma etapa

  Cenário: Critério 08: Inativar Consequencia de Evento de Risco
    Dado que o usuário esteja em lista de Consequencias de Eventos de Risco
    Quando o usuário acionar a opção "Inativar" de um item que esteja ativado
    Então o sistema inativa o Consequencia de Evento de Risco selecionado
    E desvincula o item a uma etapa, caso esteja vinculado

  Cenário: Critério 09: Excluir Consequencia de Evento de Risco
    Dado que o usuário esteja em lista de Consequencias de Eventos de Risco
    Quando o usuário acionar a opção 'Excluir' de um item desejado
    Então o sistema apresenta mensagem "Deseja excluir o registro?", com as opções 'OK' e 'Cancelar'

  Cenário: Critério 10: Confirmar Exclusão de Consequencia de Evento de Risco
    Dado que o usuário esteja excluindo um Consequencia de Evento de Risco
    Quando o usuário acionar a opção "Ok"
#    Caso não exista vinculação
    Então o sistema exclui logicamente o registro
    E apresenta a mensagem "Registro excluído com sucesso!"

  Cenário: Critério 11: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado consequencia de evento de risco
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões

  Cenário: Critério 12: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado consequencia de evento de risco
    Quando o usuário acionar a opção "Limpar"
    Então o sistema limpa os dados informados