# language: pt
# encoding: utf-8

Funcionalidade: Definir abrangência e período

  @DefinirAbrangencia
  Cenário: Critério 01: Menu Gerenciar Permissões
    Dado que o usuário esteja em menu do sistema
#    Quando o usuário acionar a opção [Gerenciar Permissões]
#    Então o sistema apresenta os parâmetros para consulta, acrescido das opções [Limpar], [Consultar] e [Novo]
#
#Critério 02: Consulta de permissão
#
#Dado que o usuário esteja em Permissões
#E informou os parâmetros necessários para a consulta
#Quando o usuário acionar a opção [Consultar]
#Então o sistema apresenta o resultado da consulta, com as colunas [Item], [Nome do Usuário], [Perfil], [Status] e as opções [Alterar], [Ativar/Inativar] e [Excluir]
#
#Critério 03: Consultando permissão sem informar dados
#
#Dado que o usuário esteja em consultar permissões
#E não informou os parâmetros necessários
#Quando o usuário acionar a opção [Consultar]
#Então o sistema apresenta a lista de permissões, com as colunas [Item], [Nome do Usuário], [Perfil], [Status] e as opções [Alterar], [Ativar/Inativar] e [Excluir], ordenado alfabeticamente pela coluna Nome do usuário
#
#Critério 04: Acionar permissão ao usuário
#
#Dado que o usuário esteja em consultar permissões
#Quando o usuário acionar a opção [Novo]
#Então o sistema apresenta a arvore somente dos "Órgãos" e "Unidade Administrativa" da Base do SIORG
#
#Critério 05: Concluindo inclusão de permissão
#
#Dado que o usuário esteja em gerenciar permissão
#Quando o usuário selecionar os "Órgãos" e "Unidade Administrativa", desejados
#Então o sistema apresenta os usuários que pertencem ao "Órgãos" e "Unidade Administrativa", para seleção Regra de Negócio 009 - Usuários arvore de unidades
#
#Critério 06: Atribuindo perfil aos usuários
#
#Dado que o usuário esteja em lista de usuários
#E informou parâmetros necessários para atribuição de perfil de acesso
#Quando o usuário acionar o botão [Gravar]
#Então o sistema salva os parâmetros salvos
#E apresenta a mensagem [Registro salvo com sucesso!]
#
#Critério 07: Alterando uma permissão
#
#Dado que o usuário realizou a consulta de uma permissão
#Quando o usuário acionar o botão [Alterar] em uma das permissões listadas
#Então o sistema apresenta os dados para serem alterados, conforme critério 06
#
#Critério 08: Concluindo a alteração de uma permissão
#
#Dado que o usuário esteja realizando a alteração de uma permissão
#E tenha alterado os parâmetros necessários
#Quando o usuário acionar o botão [Gravar]
#Então o sistema deverá salvar as edições
#E apresentar a mensagem [Registro alterado com sucesso!]
#
#Critério 09: Excluindo uma permissão
#
#Dado que o usuário realizou a consulta de uma permissão
#Quando o usuário acionar o botão [Excluir] em uma das permissões listadas
#Então o sistema apresenta a mensagem [Deseja excluir o registro?], com as opções [OK] e [Cancelar]
#
#Critério 10: Concluindo a exclusão de uma permissão
#
#Dado que o usuário acionou a exclusão de uma permissão
#Quando o usuário acionar a opção [Ok]
#Então o sistema apresenta a seguinte mensagem [Registro excluído com sucesso!]
#
#Critério 11: Validação de Campos Obrigatórios
#
#Dado que o usuário esteja em formulário para preenchimento do dado de permissões
#Quando o usuário acionar a opção [Gravar] sem preencher algum dos campos definidos como obrigatório
#Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões
#
#Critério 12: Cancelar Cadastro
#
#Dado que o usuário esteja em formulário para preenchimento do dado de permissões
#Quando o usuário acionar a opção [Cancelar Cadastro]
#Então o sistema cancela operação
#E retorna para a tela anterior
#
#Critério 13: Adicionar mais um perfil ao usuário
#
#Dado que o usuário esteja incluindo ou alterando permissões
#E já tenha incluído um perfil ao usuário selecionado
#E deseja incluir mais um perfil
#Quando o usuário acionar a opção [Adicionar]
#Então o sistema apresenta mais um campo de seleção de perfil para ser selecionado