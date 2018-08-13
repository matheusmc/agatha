# language: pt
# encoding: utf-8

Funcionalidade: US002 Autenticação OpenAm

  Como usuário do sistema
  Preciso me autenticar no sistema com minhas credenciais
  Para acessar o sistema

  @AutenticacaoOpenAm
  Cenario: Critério 01:Falha na autenticação
    Dado o usuário esteja em autenticação OPENAM
    E tenha informado os parâmetros necessários para autenticação, sem pendências
    Quando o usuário acionar a opção 'Acessar'
    Então o sistema valida os dados informados
    E apresenta a tela inicial do sistema, conforme as permissões de acesso

  @AutenticacaoOpenAm
  Cenario: Critério 02: Senha inválida
    Dado que o usuário esteja em autenticação OPENAM
    E tenha informado somente o dado CPF
    Quando o usuário aciona a opção 'Acessar'
    Então o sistema apresenta a mensagem 'Falha na autenticação'

  @AutenticacaoOpenAm
  Cenario: Critério 03: Usuário inválido
    Dado que o usuário esteja em autenticação OPENAM
    E tenha informado somente o dado Senha
    Quando o usuário aciona a opção 'Acessar'
    Então o sistema apresenta a mensagem 'Falha na autenticação'

  @AutenticacaoOpenAm
  Cenario: Critério 04: Lembrar meu usuário
    Dado que o usuário esteja em autenticação OPENAM
    E tenha informado os parâmetros necessários para autenticação, sem pendências
    E tenha acionado a opção 'Lembrar meu usuário'
    Quando o usuário acionar a opção 'Acessar'
    Então o sistema valida os dados informados
    E guarda os dados informados para a próxima autenticação do usuário logado

  @AutenticacaoOpenAm
  Cenario: Critério 05: Autenticar
    Dado que o usuário esteja em autenticação OPENAM
    E tenha informado os parâmetros necessários para autenticação, sem pendências
    Quando o usuário acionar a opção 'Acessar'
    Então o sistema valida os dados informados
    E apresenta a tela inicial do sistema, conforme as permissões de acesso

  @AutenticacaoOpenAm
  Cenario: Critério 06: Bloqueio de Usuário por várias tentativas incorretas
    Dado que o usuário tenha falhado na sua autenticação, por varias vezes
    E tenha preenchido o campo 'CPF' com um CPF que exista na base de dados
    E tenha informado a senha correta
    Quando o usuário selecionar a opção 'Acessar'
    Então o sistema deverá emitir seguinte mensagem: "Falha na autenticação."