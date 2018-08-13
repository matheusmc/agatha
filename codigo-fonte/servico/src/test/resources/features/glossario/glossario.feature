# language: pt
# encoding: utf-8

Funcionalidade: Manter Glossário

  @Glossario
  Cenário: Incluir Glossário
    Dado que o usuário esteja em Glossário
    Quando o usuário acionar a opção "Incluir"
    Então o sistema apresenta o formulário para informar dados do Glossário

  @Glossario
  Cenário: Validação de Campos Obrigatórios
    Dado que o usuário esteja em formulário para preenchimento do dado Glossário
    Quando o usuário acionar a opção "Incluir" sem preencher algum dos campos definidos como obrigatório
    Então o sistema deve destacar o(s) campo(s) que não foram preenchidos, em vermelho e apresentar as mensagens padrões

  @Glossario
  Cenário: Limpar dados
    Dado que o usuário esteja em formulário para preenchimento do dado Glossário
    Quando o usuário acionar a opção "Limpar"
    Então o sistema limpa os dados informados