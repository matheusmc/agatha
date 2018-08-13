/*INICIO INSERTS tb_causa*/
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (1, 'Causa 1', 't', 'f', 'Causa 1', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (2, 'Causa 2', 't', 'f', 'Causa 2', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (3, 'Causa 3', 't', 'f', 'Causa 3', NULL);
/*FIM INSERTS tb_causa*/
/*INICIO INSERTS tb_categoria_unidade*/
INSERT INTO gestaoriscos.tb_categoria_unidade (id_categoria_unidade, no_categoria, sg_categoria_unidade) VALUES(0, 'Sem Categoria', 'SC');
INSERT INTO gestaoriscos.tb_categoria_unidade (id_categoria_unidade, no_categoria, sg_categoria_unidade) VALUES(1, 'Unidade Administrativa', 'UA');
INSERT INTO gestaoriscos.tb_categoria_unidade (id_categoria_unidade, no_categoria, sg_categoria_unidade) VALUES(2, 'Unidade Colegiada', 'UC');
INSERT INTO gestaoriscos.tb_categoria_unidade (id_categoria_unidade, no_categoria, sg_categoria_unidade) VALUES(3, 'Entidade', 'EN');
INSERT INTO gestaoriscos.tb_categoria_unidade (id_categoria_unidade, no_categoria, sg_categoria_unidade) VALUES(4, 'Órgão', 'OR');
INSERT INTO gestaoriscos.tb_categoria_unidade (id_categoria_unidade, no_categoria, sg_categoria_unidade) VALUES(5, 'Ente', 'ET');
/*FIM INSERTS tb_categoria_unidade*/
/*INICIO INSERTS tb_natureza_juridica*/
INSERT INTO gestaoriscos.tb_natureza_juridica(id_natureza_juridica, no_natureza_juridica) VALUES (1, 'Empresa Pública');
INSERT INTO gestaoriscos.tb_natureza_juridica(id_natureza_juridica, no_natureza_juridica) VALUES (2, 'Fundação Pública');
INSERT INTO gestaoriscos.tb_natureza_juridica(id_natureza_juridica, no_natureza_juridica) VALUES (3, 'Administração Direta');
INSERT INTO gestaoriscos.tb_natureza_juridica(id_natureza_juridica, no_natureza_juridica) VALUES (4, 'Autarquia');
INSERT INTO gestaoriscos.tb_natureza_juridica(id_natureza_juridica, no_natureza_juridica) VALUES (6, 'Sociedade de Economia Mista');
/*FIM INSERTS tb_natureza_juridica*/
/*INICIO INSERTS tb_tipo_matriz*/
INSERT INTO gestaoriscos.tb_tipo_matriz(id_tipo_matriz, ic_excluido, no_tipo_matriz) VALUES (1, false, 'Pontos Fortes');
INSERT INTO gestaoriscos.tb_tipo_matriz(id_tipo_matriz, ic_excluido, no_tipo_matriz) VALUES (2, false, 'Oportunidades');
INSERT INTO gestaoriscos.tb_tipo_matriz(id_tipo_matriz, ic_excluido, no_tipo_matriz) VALUES (3, false, 'Pontos Fracos');
INSERT INTO gestaoriscos.tb_tipo_matriz(id_tipo_matriz, ic_excluido, no_tipo_matriz) VALUES (4, false, 'Ameaças');
/*FIM INSERTS tb_tipo_matriz*/
/*INICIO INSERTS tb_status_processo*/
INSERT INTO "gestaoriscos"."tb_status_processo" ("id_status_processo", "ic_excluido", "no_status") VALUES (1, false, 'Não Finalizado');
INSERT INTO "gestaoriscos"."tb_status_processo" ("id_status_processo", "ic_excluido", "no_status") VALUES (2, false, 'Finalizado');
/*FIM INSERTS tb_status_processo*/
/*INICIO INSERTS tb_status_processo*/
INSERT INTO "gestaoriscos"."tb_decisao_processo" ("id_decisao_processo", "ic_excluido", "no_decisao") VALUES (1, false, 'Validar');
INSERT INTO "gestaoriscos"."tb_decisao_processo" ("id_decisao_processo", "ic_excluido", "no_decisao") VALUES (2, false, 'Rejeitar');
/*FIM INSERTS tb_status_processo*/
/*INICIO INSERTS tb_natureza*/
INSERT INTO gestaoriscos.tb_natureza(id_natureza, ic_excluido, ic_ativo, ds_natureza, ds_search) VALUES (1, false, true, 'Orçamentario Financeiro' , 'Orcamentario Financeiro');
INSERT INTO gestaoriscos.tb_natureza(id_natureza, ic_excluido, ic_ativo, ds_natureza, ds_search) VALUES (2, false, true, 'Não Orçamentario Financeiro' , 'Nao Orcamentario Financeiro');
/*FIM INSERTS tb_natureza*/
/*INICIO INSERTS tb_categoria*/
INSERT INTO gestaoriscos.tb_categoria(id_categoria, ic_excluido, ic_ativo, ds_categoria, ds_search, id_natureza) VALUES (1, false, true, 'Estratégico' , 'Estrategico', 1);
INSERT INTO gestaoriscos.tb_categoria(id_categoria, ic_excluido, ic_ativo, ds_categoria, ds_search, id_natureza) VALUES (2, false, true, 'Operacional' , 'Operacional', 1);
INSERT INTO gestaoriscos.tb_categoria(id_categoria, ic_excluido, ic_ativo, ds_categoria, ds_search, id_natureza) VALUES (3, false, true, 'Orçamentário' , 'Orcamentario', 1);
INSERT INTO gestaoriscos.tb_categoria(id_categoria, ic_excluido, ic_ativo, ds_categoria, ds_search, id_natureza) VALUES (4, false, true, 'Reputação' , 'Reputacao', 1);
INSERT INTO gestaoriscos.tb_categoria(id_categoria, ic_excluido, ic_ativo, ds_categoria, ds_search, id_natureza) VALUES (5, false, true, 'Integridade' , 'Integridade', 1);
INSERT INTO gestaoriscos.tb_categoria(id_categoria, ic_excluido, ic_ativo, ds_categoria, ds_search, id_natureza) VALUES (6, false, true, 'Fiscal' , 'Fiscal', 1);
/*FIM INSERTS tb_categoria*/
/*INICIO INSERTS tb_macroprocesso*/
INSERT INTO gestaoriscos.tb_macroprocesso("id_macroprocesso", "ds_macroprocesso", "ic_ativo", "ic_excluido", "ds_search") VALUES (1, 'Macroprocesso 01', true, false, 'Macroprocesso 01');
INSERT INTO gestaoriscos.tb_macroprocesso("id_macroprocesso", "ds_macroprocesso", "ic_ativo", "ic_excluido", "ds_search") VALUES (2, 'Macroprocesso 02', true, false, 'Macroprocesso 02');
INSERT INTO gestaoriscos.tb_macroprocesso("id_macroprocesso", "ds_macroprocesso", "ic_ativo", "ic_excluido", "ds_search") VALUES (3, 'Macroprocesso 03', true, false, 'Macroprocesso 03');
/*FIM INSERTS tb_categoria*/
/*INICIO INSERTS tb_calculo_risco*/
INSERT INTO "gestaoriscos"."tb_calculo_risco" ("id_calculo_risco", "ic_excluido", "nu_media_peso", "nu_frequencia", "nu_nivel") VALUES (1, false, 10, 10, 10);
INSERT INTO "gestaoriscos"."tb_calculo_risco" ("id_calculo_risco", "ic_excluido", "nu_media_peso", "nu_frequencia", "nu_nivel") VALUES (2, false, 20, 10, 10);
INSERT INTO "gestaoriscos"."tb_calculo_risco" ("id_calculo_risco", "ic_excluido", "nu_media_peso", "nu_frequencia", "nu_nivel") VALUES (3, false, 30, 10, 10);
INSERT INTO "gestaoriscos"."tb_calculo_risco" ("id_calculo_risco", "ic_excluido", "nu_media_peso", "nu_frequencia", "nu_nivel") VALUES (4, false, 5, 10, 10);
/*FIM INSERTS tb_calculo_risco*/
/*INICIO INSERTS tb_tipo_calculadora*/
INSERT INTO gestaoriscos.tb_tipo_calculadora(id_tipo_calculadora, no_tipo_calculadora, ic_excluido) VALUES (1, 'Calculadora do Risco Inerente', false);
INSERT INTO gestaoriscos.tb_tipo_calculadora(id_tipo_calculadora, no_tipo_calculadora, ic_excluido) VALUES (2, 'Calculadora do Risco Residual', false);
/*FIM INSERTS tb_tipo_calculadora*/
/*INICIO INSERTS tb_calculadora*/
INSERT INTO gestaoriscos.tb_calculadora(id_calculadora, ic_excluido, id_tipo_calculadora) VALUES (1, false, 1);
INSERT INTO gestaoriscos.tb_calculadora(id_calculadora, ic_excluido, id_tipo_calculadora) VALUES (2, false, 2);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (1, 'Esforço de Gestão', 15, false, 1, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (2, 'Regulação', 17, false, 1, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (3, 'Reputação', 12, false, 1, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (4, 'Negócios/Serviços à Sociedade', 18, false, 1, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (5, 'Intervenção Hierárquica', 13, false, 1, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (6, 'Valor Orçamentário', 25, false, 1, false);

INSERT INTO gestaoriscos.tb_probabilidade_calculadora(id_probabilidade_calculadora, no_probabilidade_calculadora, nu_frequencia, ic_excluido, id_calculadora)
VALUES (1, 'Evento esperado que ocorra na maioria das circunstâncias', 10, false, 1);
INSERT INTO gestaoriscos.tb_probabilidade_calculadora(id_probabilidade_calculadora, no_probabilidade_calculadora, nu_frequencia, ic_excluido, id_calculadora)
VALUES (2, 'Evento provavelmente ocorra na maioria das circunstâncias', 30, false, 1);
INSERT INTO gestaoriscos.tb_probabilidade_calculadora(id_probabilidade_calculadora, no_probabilidade_calculadora, nu_frequencia, ic_excluido, id_calculadora)
VALUES (3, 'Evento deve ocorrer em algum momento', 50, false, 1);
INSERT INTO gestaoriscos.tb_probabilidade_calculadora(id_probabilidade_calculadora, no_probabilidade_calculadora, nu_frequencia, ic_excluido, id_calculadora)
VALUES (4, 'Evento pode ocorrer em algum momento', 90, false, 1);
INSERT INTO gestaoriscos.tb_probabilidade_calculadora(id_probabilidade_calculadora, no_probabilidade_calculadora, nu_frequencia, ic_excluido, id_calculadora)
VALUES (5, 'Evento pode ocorrer em algum momento', 90, false, 1);
/*FIM INSERTS tb_calculadora*/
/*INICIO INSERTS tb_tipo_taxonomia*/
INSERT INTO gestaoriscos.tb_tipo_taxonomia (id_tipo_taxonomia, no_tipo_taxonomia, ic_excluido) VALUES (1, 'Evento', false);
INSERT INTO gestaoriscos.tb_tipo_taxonomia (id_tipo_taxonomia, no_tipo_taxonomia, ic_excluido) VALUES (2, 'Causa', false);
INSERT INTO gestaoriscos.tb_tipo_taxonomia (id_tipo_taxonomia, no_tipo_taxonomia, ic_excluido) VALUES (3, 'Consequência', false);
INSERT INTO gestaoriscos.tb_tipo_taxonomia (id_tipo_taxonomia, no_tipo_taxonomia, ic_excluido) VALUES (4, 'Controle', false);
/*FIM INSERTS tb_tipo_taxonomia*/
/*INICIO INSERTS tb_status_taxonomia*/
INSERT INTO gestaoriscos.tb_status_taxonomia (id_status_taxonomia, no_status_taxonomia, ic_excluido) VALUES (1, 'Não avaliado', false);
INSERT INTO gestaoriscos.tb_status_taxonomia (id_status_taxonomia, no_status_taxonomia, ic_excluido) VALUES (2, 'Aprovado', false);
INSERT INTO gestaoriscos.tb_status_taxonomia (id_status_taxonomia, no_status_taxonomia, ic_excluido) VALUES (3, 'Reprovado', false);
INSERT INTO gestaoriscos.tb_status_taxonomia (id_status_taxonomia, no_status_taxonomia, ic_excluido) VALUES (4, 'Agrupado', false);
/*FIM INSERTS tb_status_taxonomia*/
/*INICIO INSERTS tb_tipo_resposta_risco*/
INSERT INTO gestaoriscos.tb_resposta_risco (id_resposta_risco, no_resposta_risco, ic_excluido) VALUES (1, 'Evitar', false);
INSERT INTO gestaoriscos.tb_resposta_risco (id_resposta_risco, no_resposta_risco, ic_excluido) VALUES (2, 'Reduzir', false);
INSERT INTO gestaoriscos.tb_resposta_risco (id_resposta_risco, no_resposta_risco, ic_excluido) VALUES (3, 'Compartilhar/Transferir', false);
INSERT INTO gestaoriscos.tb_resposta_risco (id_resposta_risco, no_resposta_risco, ic_excluido) VALUES (4, 'Aceitar', false);
/*FIM INSERTS tb_tipo_resposta_risco*/
/*INICIO INSERTS tb_tipo_controle*/
INSERT INTO gestaoriscos.tb_tipo_controle (id_tipo_controle, no_tipo_controle, ic_excluido) VALUES (1, 'Corretivo', false);
INSERT INTO gestaoriscos.tb_tipo_controle (id_tipo_controle, no_tipo_controle, ic_excluido) VALUES (2, 'Preventivo', false);
/*FIM INSERTS tb_tipo_controle*/
/*INICIO INSERTS tb_objetivo_controle*/
INSERT INTO gestaoriscos.tb_objetivo_controle (id_objetivo_controle, no_objetivo_controle, ic_excluido) VALUES (1, 'Melhoria de Controle Existente', false);
INSERT INTO gestaoriscos.tb_objetivo_controle (id_objetivo_controle, no_objetivo_controle, ic_excluido) VALUES (2, 'Adotar Controle Novo', false);
/*FIM INSERTS tb_objetivo_controle*/
/*INICIO INSERTS tb_perfil*/
INSERT INTO gestaoriscos.tb_perfil (id_perfil, no_perfil) VALUES (1, 'Comitê');
INSERT INTO gestaoriscos.tb_perfil (id_perfil, no_perfil) VALUES (2, 'Subcomitê');
INSERT INTO gestaoriscos.tb_perfil (id_perfil, no_perfil) VALUES (3, 'Núcleo');
INSERT INTO gestaoriscos.tb_perfil (id_perfil, no_perfil) VALUES (4, 'Unidade');
INSERT INTO gestaoriscos.tb_perfil (id_perfil, no_perfil) VALUES (5, 'Gestor do Processo');
INSERT INTO gestaoriscos.tb_perfil (id_perfil, no_perfil) VALUES (6, 'Analista de Risco');
/*FIM INSERTS tb_perfil*/
/*INICIO INSERTS tb_agrupamento_taxonomia*/
INSERT INTO "gestaoriscos"."tb_orgao" ("id_orgao", "no_orgao", "id_orgao_superior", "sg_orgao", "id_categoria_unidade", "id_natureza_juridica") VALUES (1, 'orgao1', NULL, 'orgao', 1, 1);
INSERT INTO "gestaoriscos"."tb_orgao" ("id_orgao", "no_orgao", "id_orgao_superior", "sg_orgao", "id_categoria_unidade", "id_natureza_juridica") VALUES (2, 'orgao2', NULL, 'orgao', 1, 1);
INSERT INTO "gestaoriscos"."tb_orgao" ("id_orgao", "no_orgao", "id_orgao_superior", "sg_orgao", "id_categoria_unidade", "id_natureza_juridica") VALUES (3, 'orgao3', NULL, 'orgao', 1, 1);
INSERT INTO "gestaoriscos"."tb_orgao" ("id_orgao", "no_orgao", "id_orgao_superior", "sg_orgao", "id_categoria_unidade", "id_natureza_juridica") VALUES (4, 'orgao4', 1, 'orgao', 1, 1);
/*FIM INSERTS tb_agrupamento_taxonomia*/
/*INICIO INSERTS tb_evento*/
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (1, 'evento1', true, false, 'evento1', NULL);
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (2, 'evento2', true, false, 'evento2', NULL);
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (3, 'evento3', true, false, 'evento3', NULL);
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (4, 'evento4', true, false, 'evento4', 1);
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (5, 'evento4', true, false, 'evento4', 1);
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (6, 'evento4', true, false, 'evento4', 1);
INSERT INTO "gestaoriscos"."tb_evento" ("id_evento", "ds_evento", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (7, 'evento7', true, false, 'evento7', null);

INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (4, 'Causa 4', 't', 'f', 'Causa 4', 1);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (5, 'Causa 5', 't', 'f', 'Causa 5', 1);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (6, 'Causa 6', 't', 'f', 'Causa 6', 1);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (7, 'Causa 7', 't', 'f', 'Causa 7', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (8, 'Causa 8', 't', 'f', 'Causa 8', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (9, 'Causa 9', 't', 'f', 'Causa 9', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (10, 'Causa 10', 't', 'f', 'Causa 10', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (11, 'Causa 11', 't', 'f', 'Causa 11', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (12, 'Causa 12', 't', 'f', 'Causa 12', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (13, 'Causa 13', 't', 'f', 'Causa 13', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (14, 'Causa 14', 't', 'f', 'Causa 14', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (15, 'Causa 15', 't', 'f', 'Causa 15', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (16, 'Causa 16', 't', 'f', 'Causa 16', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (17, 'Causa 17', 't', 'f', 'Causa 17', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (18, 'Causa 18', 't', 'f', 'Causa 18', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (19, 'Causa 19', 't', 'f', 'Causa 19', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (20, 'Causa 20', 't', 'f', 'Causa 20', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (21, 'Causa 21', 't', 'f', 'Causa 21', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (22, 'Causa 22', 't', 'f', 'Causa 22', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (23, 'Causa 23', 't', 'f', 'Causa 23', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (24, 'Causa 24', 't', 'f', 'Causa 24', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (25, 'Causa 25', 't', 'f', 'Causa 25', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (26, 'Causa 26', 't', 'f', 'Causa 26', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (27, 'Causa 27', 't', 'f', 'Causa 27', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (28, 'Causa 28', 't', 'f', 'Causa 28', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (29, 'Causa 29', 't', 'f', 'Causa 29', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (30, 'Causa 30', 't', 'f', 'Causa 30', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (31, 'Causa 31', 't', 'f', 'Causa 31', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (32, 'Causa 32', 't', 'f', 'Causa 32', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (33, 'Causa 33', 't', 'f', 'Causa 33', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (34, 'Causa 34', 't', 'f', 'Causa 34', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (35, 'Causa 35', 't', 'f', 'Causa 35', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (36, 'Causa 36', 't', 'f', 'Causa 36', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (37, 'Causa 37', 't', 'f', 'Causa 37', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (38, 'Causa 38', 't', 'f', 'Causa 38', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (39, 'Causa 39', 't', 'f', 'Causa 39', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (40, 'Causa 40', 't', 'f', 'Causa 40', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (41, 'Causa 41', 't', 'f', 'Causa 41', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (42, 'Causa 42', 't', 'f', 'Causa 42', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (43, 'Causa 43', 't', 'f', 'Causa 43', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (44, 'Causa 44', 't', 'f', 'Causa 44', NULL);
INSERT INTO gestaoriscos.tb_causa("id_causa", "ds_causa", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (45, 'Causa 45', 't', 'f', 'Causa 45', NULL);

/*FIM INSERTS tb_evento*/
/*INICIO INSERTS tb_consequencia*/
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (1, 'consequencia1', true, false, 'consequencia1', NULL);
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (2, 'consequencia2', true, false, 'consequencia2', NULL);
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (3, 'consequencia3', true, false, 'consequencia3', NULL);
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (4, 'consequencia4', true, false, 'consequencia4', 1);
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (5, 'consequencia5', true, false, 'consequencia5', 1);
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (6, 'consequencia6', true, false, 'consequencia6', 1);
INSERT INTO "gestaoriscos"."tb_consequencia" ("id_consequencia", "ds_consequencia", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (7, 'consequencia6', true, false, 'consequencia7', null);
/*FIM INSERTS tb_consequencia*/
/*INICIO INSERTS tb_controle*/
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (1, 'controle1', true, false, 'controle1', NULL);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (2, 'controle2', true, false, 'controle2', NULL);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (3, 'controle3', true, false, 'controle3', NULL);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (4, 'controle4', true, false, 'controle4', 1);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (5, 'controle5', true, false, 'controle5', 1);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (6, 'controle6', true, false, 'controle6', 1);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (7, 'controle7', false, false, 'controle7', NULL);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (8, 'controle7', false, false, 'controle8', NULL);
INSERT INTO "gestaoriscos"."tb_controle" ("id_controle", "ds_controle", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (9, 'controle9', true, false, 'controle9', NULL);
/*FIM INSERTS tb_controle*/
/*INICIO INSERTS tb_taxonomia*/
INSERT INTO "gestaoriscos"."tb_taxonomia" ("id_taxonomia", "ds_taxonomia", "ds_search", "dt_cadastro", "ic_excluido", "ds_justificativa", "id_tipo_taxonomia", "id_status_taxonomia", "id_orgao", "id_evento", "id_causa", "id_consequencia", "id_controle", "id_agrupamento_taxonomia") VALUES (1, 'taxonomia1', 'taxonomia', NOW(), false, 'taxonomia', 1, 1, 1, 1, 1, 1, 1, NULL);
/*INICIO INSERTS tb_agrupamento_taxonomia*/
INSERT INTO "gestaoriscos"."tb_agrupamento_taxonomia" ("id_agrupamento_taxonomia", "ic_excluido", "id_taxonomia_padrao") VALUES (1, false, 1);
INSERT INTO "gestaoriscos"."tb_agrupamento_taxonomia" ("id_agrupamento_taxonomia", "ic_excluido", "id_taxonomia_padrao") VALUES (2, false, 1);
INSERT INTO "gestaoriscos"."tb_agrupamento_taxonomia" ("id_agrupamento_taxonomia", "ic_excluido", "id_taxonomia_padrao") VALUES (3, false, 1);
/*FIM INSERTS tb_agrupamento_taxonomia*/
INSERT INTO "gestaoriscos"."tb_taxonomia" ("id_taxonomia", "ds_taxonomia", "ds_search", "dt_cadastro", "ic_excluido", "ds_justificativa", "id_tipo_taxonomia", "id_status_taxonomia", "id_orgao", "id_evento", "id_causa", "id_consequencia", "id_controle", "id_agrupamento_taxonomia") VALUES (2, 'taxonomia2', 'taxonomia', NOW(), false, 'taxonomia2', 2, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_taxonomia" ("id_taxonomia", "ds_taxonomia", "ds_search", "dt_cadastro", "ic_excluido", "ds_justificativa", "id_tipo_taxonomia", "id_status_taxonomia", "id_orgao", "id_evento", "id_causa", "id_consequencia", "id_controle", "id_agrupamento_taxonomia") VALUES (3, 'taxonomia3', 'taxonomia', NOW(), false, 'taxonomia3', 3, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_taxonomia" ("id_taxonomia", "ds_taxonomia", "ds_search", "dt_cadastro", "ic_excluido", "ds_justificativa", "id_tipo_taxonomia", "id_status_taxonomia", "id_orgao", "id_evento", "id_causa", "id_consequencia", "id_controle", "id_agrupamento_taxonomia") VALUES (4, 'taxonomia4', 'taxonomia', NOW(), false, 'taxonomia4', 4, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_taxonomia" ("id_taxonomia", "ds_taxonomia", "ds_search", "dt_cadastro", "ic_excluido", "ds_justificativa", "id_tipo_taxonomia", "id_status_taxonomia", "id_orgao", "id_evento", "id_causa", "id_consequencia", "id_controle", "id_agrupamento_taxonomia") VALUES (5, 'taxonomia5', 'taxonomia', NOW(), false, 'taxonomia5', 4, 1, 1, 7, 45, 7, 9, 1);
/*FIM INSERTS tb_taxonomia*/
/*INICIO INSERTS tb_usuario*/
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (1, 'Usuario1', '11111111111', 1);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (2, 'Usuario2', '22222222222', 1);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (3, 'Usuario3', '33333333333', 1);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (4, 'Usuario4', '44444444444', 1);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (5, 'Usuario5', '55555555555', 1);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (6, 'Usuario6', '66666666666', 1);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (7, 'Usuario7', '77777777777', 4);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (8, 'Usuario8', '88888888888', 4);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (9, 'Usuario9', '99999999999', 4);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (10, 'Usuario10', '00000000000', 4);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (11, 'Usuario11', '11111111112', 4);
INSERT INTO "gestaoriscos"."tb_usuario" ("id_usuario", "no_usuario", "nu_cpf", "id_orgao") VALUES (12, 'Usuario12', '12121212121', 4);
/*FIM INSERTS tb_usuario*/
/*INICIO INSERTS tb_desenho*/
INSERT INTO "gestaoriscos"."tb_desenho" ("id_desenho", "ds_desenho", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (1, 'desenho1', true, false, 'desenho1', null);
INSERT INTO "gestaoriscos"."tb_desenho" ("id_desenho", "ds_desenho", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (2, 'desenho2', true, false, 'desenho2', null);
INSERT INTO "gestaoriscos"."tb_desenho" ("id_desenho", "ds_desenho", "ic_ativo", "ic_excluido", "ds_search", "id_orgao") VALUES (3, 'desenho3', true, false, 'desenho3', null);
/*FIM INSERTS tb_desenho*/
/*INICIO INSERTS TB_IDENTIFICACAO*/
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (1, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (2, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (3, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (4, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (5, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (6, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (7, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (8, TRUE);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (9, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (10, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (11, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (12, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (13, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (14, false);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (15, true);
INSERT INTO "gestaoriscos"."tb_identificacao" ("id_identificacao", "ic_excluido")
VALUES (16, true);
/*FIM INSERTS TB_IDENTIFICACAO*/
/*INICIO INSERTS tb_evento_risco*/
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (1, false, 1, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (2, false, 1, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (3, false, 1, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (4, false, 4, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (5, false, 5, 1, 5, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (6, false, 6, 1, 6, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (7, false, 6, 1, 7, NULL, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (8, false, 6, 1, 7, 3, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (9, false, 6, 1, 9, 3, 1);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (10, false, 6, 1, 10, 3, 2);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (11, false, 6, 1, 10, 3, NULL);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (12, false, 6, 1, 11, 3, 2);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (13, false, 2, 1, 15, 3, 2);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual") VALUES (14, false, 6, 1, 10, NULL, NULL);
INSERT INTO "gestaoriscos"."tb_evento_risco" ("id_evento_risco", "ic_excluido", "id_evento", "id_categoria", "id_identificacao", "id_calculo_risco_inerente", "id_calculo_risco_residual", "id_resposta_risco") VALUES (15, false, 5, 1, 16, 1, 1, 1);
/*FIM INSERTS tb_evento_risco*/
/*INICIO INSERTS TB_OPERACAO*/
INSERT INTO "gestaoriscos"."tb_operacao" ("id_operacao", "ds_operacao", "ic_ativo", "ic_excluido", "ds_search", "id_orgao")
VALUES (1, 'Descricao Operacao 1', true, false, 'Descricao Operacao 1', null);
INSERT INTO "gestaoriscos"."tb_operacao" ("id_operacao", "ds_operacao", "ic_ativo", "ic_excluido", "ds_search", "id_orgao")
VALUES (2, 'Descricao Operacao 2', true, false, 'Descricao Operacao 2', null);
INSERT INTO "gestaoriscos"."tb_operacao" ("id_operacao", "ds_operacao", "ic_ativo", "ic_excluido", "ds_search", "id_orgao")
VALUES (3, 'Descricao Operacao 3', true, false, 'Descricao Operacao 3', null);
/*FIM INSERTS TB_OPERACAO*/
/*INICIO INSERTS tb_controle_evento*/
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (1, false, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (2, false, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (3, false, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (4, false, 4, 1, 1, 4);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (5, false, 5, 1, 1, 5);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (6, false, 6, 1, 1, 7);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (7, false, 7, 1, 1, 10);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (8, false, 7, 1, 1, 11);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (9, false, 2, 1, 1, 11);
INSERT INTO "gestaoriscos"."tb_controle_evento" ("id_controle_evento", "ic_excluido", "id_controle", "id_desenho", "id_operacao", "id_evento_risco") VALUES (10, false, 2, 1, 1, 15);
/*FIM INSERTS tb_controle_evento*/
/*INICIO INSERTS tb_evento_causa*/
INSERT INTO "gestaoriscos"."tb_evento_causa" ("id_evento_causa", "ic_excluido", "id_evento_risco", "id_causa") VALUES (1, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_causa" ("id_evento_causa", "ic_excluido", "id_evento_risco", "id_causa") VALUES (2, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_causa" ("id_evento_causa", "ic_excluido", "id_evento_risco", "id_causa") VALUES (3, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_causa" ("id_evento_causa", "ic_excluido", "id_evento_risco", "id_causa") VALUES (4, false, 4, 4);
INSERT INTO "gestaoriscos"."tb_evento_causa" ("id_evento_causa", "ic_excluido", "id_evento_risco", "id_causa") VALUES (5, false, 5, 5);
INSERT INTO "gestaoriscos"."tb_evento_causa" ("id_evento_causa", "ic_excluido", "id_evento_risco", "id_causa") VALUES (6, false, 6, 6);
/*FIM INSERTS tb_evento_causa*/
/*INICIO INSERTS tb_evento_consequencia*/
INSERT INTO "gestaoriscos"."tb_evento_consequencia" ("id_evento_consequencia", "ic_excluido", "id_evento_risco", "id_consequencia") VALUES (1, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_consequencia" ("id_evento_consequencia", "ic_excluido", "id_evento_risco", "id_consequencia") VALUES (2, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_consequencia" ("id_evento_consequencia", "ic_excluido", "id_evento_risco", "id_consequencia") VALUES (3, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_evento_consequencia" ("id_evento_consequencia", "ic_excluido", "id_evento_risco", "id_consequencia") VALUES (4, false, 4, 4);
INSERT INTO "gestaoriscos"."tb_evento_consequencia" ("id_evento_consequencia", "ic_excluido", "id_evento_risco", "id_consequencia") VALUES (5, false, 5, 5);
INSERT INTO "gestaoriscos"."tb_evento_consequencia" ("id_evento_consequencia", "ic_excluido", "id_evento_risco", "id_consequencia") VALUES (6, false, 6, 6);
/*FIM INSERTS tb_evento_consequencia*/

/*INICIO INSERTS TB_ANALISE*/
INSERT INTO "gestaoriscos"."tb_analise" ("id_analise", "ic_atribuicoes", "ic_estrutura", "ic_etica", "ic_excluido", "ic_missao", "ic_normas_internas", "ic_objetivos", "ic_recursos_humanos", "ic_visao", "id_orgao", "id_secretaria")
VALUES (1, true, true, true, false, true, true, true, true, true, 1, 1);
INSERT INTO "gestaoriscos"."tb_analise" ("id_analise", "ic_atribuicoes", "ic_estrutura", "ic_etica", "ic_excluido", "ic_missao", "ic_normas_internas", "ic_objetivos", "ic_recursos_humanos", "ic_visao", "id_orgao", "id_secretaria")
VALUES (2, true, true, true, false, true, true, true, true, true, 2, 2);
INSERT INTO "gestaoriscos"."tb_analise" ("id_analise", "ic_atribuicoes", "ic_estrutura", "ic_etica", "ic_excluido", "ic_missao", "ic_normas_internas", "ic_objetivos", "ic_recursos_humanos", "ic_visao", "id_orgao", "id_secretaria")
VALUES (3, true, true, true, false, true, true, true, true, true, 3, 3);
/*FIM INSERTS TB_ANALISE*/

/*INICIO INSERTS TB_AVALIACAO*/
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (1, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (2, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (3, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (4, false, false);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (5, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (6, false, false);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (7, false, false);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (8, false, false);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (9, false, false);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (10, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (11, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (12, false, true);
INSERT INTO "gestaoriscos"."tb_avaliacao" ("id_avaliacao", "ic_excluido", "ic_ignorar_risco_inerente")
VALUES (13, false, true);
/*FIM INSERTS TB_AVALIACAO*/

/*INICIO INSERTS TB_PROCESSO*/
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (1, 'Nome Coordenacao 1', 'Nome Diretoria 1', NOW(), NOW(), false, 'Nome Lei 1', 'Descricao Processo 1', 'Nome Processo 1', 'Nome Sistema 1', 1, 1, 1, 1, 1, 'Processo 1', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (2, 'Nome Coordenacao 2', 'Nome Diretoria 2', NOW(), NOW(), false, 'Nome Lei 2', 'Descricao Processo 2', 'Nome Processo 2', 'Nome Sistema 2', 2, 2, 2, 2, 2, 'Processo 2', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (3, 'Nome Coordenacao 3', 'Nome Diretoria 3', NOW(), NOW(), false, 'Nome Lei 3', 'Descricao Processo 3', 'Nome Processo 3', 'Nome Sistema 3', 3, 3, 3, 3, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (4, 'Nome Coordenacao 4', 'Nome Diretoria 4', NOW(), NOW(), false, 'Nome Lei 4', 'Descricao Processo 4', 'Nome Processo 4', 'Nome Sistema 4', NULL , NULL, 4, 4, 1, 'Processo 4', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (5, 'Nome Coordenacao 5', 'Nome Diretoria 5', NOW(), NOW(), false, 'Nome Lei 5', 'Descricao Processo 5', 'Nome Processo 5', 'Nome Sistema 5', NULL , NULL, 5, 5, 2, 'Processo 5', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (6, 'Nome Coordenacao 6', 'Nome Diretoria 6', NOW(), NOW(), false, 'Nome Lei 6', 'Descricao Processo 6', 'Nome Processo 6', 'Nome Sistema 6', NULL , NULL, 6, 5, 2, 'Processo 6', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (7, 'Nome Coordenacao 7', 'Nome Diretoria 7', NOW(), NOW(), false, 'Nome Lei 7', 'Descricao Processo 7', 'Nome Processo 7', 'Nome Sistema 7', NULL , 4, 6, 7, 2, 'Processo 7', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (8, 'Nome Coordenacao 8', 'Nome Diretoria 8', NOW(), NOW(), false, 'Nome Lei 8', 'Descricao Processo 8', 'Nome Processo 8', 'Nome Sistema 8', NULL , 5, 6, 8, 2, 'Processo 7', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (9, 'Nome Coordenacao 9', 'Nome Diretoria 9', NOW(), NOW(), false, 'Nome Lei 9', 'Descricao Processo 9', 'Nome Processo 9', 'Nome Sistema 9', NULL , NULL, 6, 9, 2, 'Processo 7', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (10, 'Nome Coordenacao 3', 'Nome Diretoria 3', NOW(), NOW(), false, 'Nome Lei 3', 'Nome Processo 3', 'Nome Processo 3', 'Nome Sitema', null, 6, 11, NULL, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (11, 'Nome Coordenacao 3', 'Nome Diretoria 3', NOW(), NOW(), false, 'Nome Lei 3', 'Descricao Processo 11', 'Nome Processo 31', 'Nome Sistema 3', NULL, 7, 10, 9, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (12, 'Nome Coordenacao 3', 'Nome Diretoria 3', NOW(), NOW(), false, 'Nome Lei 3', 'Descricao Processo 12', 'Nome Processo 32', 'Nome Sistema 3', NULL, NULL, 10, NULL, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (13, 'Nome Coordenacao 3', 'Nome Diretoria 3', NOW(), NOW(), false, 'Nome Lei 3', 'Descricao Processo 13', 'Nome Processo 33', 'Nome Sistema 3', NULL, 8, 10, 10, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (14, 'Nome Coordenacao 3', 'Nome Diretoria 3', NOW(), NOW(), false, 'Nome Lei 3', 'Descricao Processo 14', 'Nome Processo 34', 'Nome Sistema 3', NULL, 9, 10, 11, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (15, 'Nome Coordenacao 15', 'Nome Diretoria 15', NOW(), NOW(), false, 'Nome Lei 15', 'Descricao Processo 15', 'Nome Processo 35', 'Nome Sistema 3', NULL, 10, 11, 12, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (16, 'Nome Coordenacao 15', 'Nome Diretoria 15', NOW(), NOW(), false, 'Nome Lei 15', 'Descricao Processo 16', 'Nome Processo 36', 'Nome Sistema 3', NULL, NULL, 11, 13, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (17, 'Nome Coordenacao 15', 'Nome Diretoria 15', NOW(), NOW(), false, 'Nome Lei 15', 'Descricao Processo 17', 'Nome Processo 37', 'Nome Sistema 3', NULL, 11, 11, 14, 2, 'Processo 3', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (18, 'Nome Coordenacao 18', 'Nome Diretoria 18', NOW(), NOW(), false, 'Nome Lei 8', 'Descricao Processo 18', 'Nome Processo 38', 'Nome Sistema 8', NULL , 12, 10, 15, 2, 'Processo 7', NOW(), 1);
INSERT INTO "gestaoriscos"."tb_processo" ("id_processo", "no_coordenacao", "no_diretoria", "dt_fim", "dt_inicio", "ic_excluido", "no_lei", "ds_objetivo", "no_processo", "no_sistema", "id_analise", "id_avaliacao", "id_usuario", "id_identificacao", "id_status_processo", "ds_search", "dt_cadastro", "id_macroprocesso")
VALUES (19, 'Nome Coordenacao 19', 'Nome Diretoria 19', NOW(), NOW(), false, 'Nome Lei 19', 'Descricao Processo 19', 'Nome Processo 19', 'Nome Sistema 19', NULL, 13, 1, 16, 1, 'Processo 19', NOW(), 1);
/*FIM INSERTS TB_PROCESSO*/

/*INICIO INSERTS TB_CALCULADORA*/
INSERT INTO gestaoriscos.tb_calculadora(id_calculadora, ic_excluido, id_tipo_calculadora, id_processo) VALUES (3, false, 1, 1);
INSERT INTO gestaoriscos.tb_calculadora(id_calculadora, ic_excluido, id_tipo_calculadora, id_processo) VALUES (4, false, 2, 1);
INSERT INTO gestaoriscos.tb_calculadora(id_calculadora, ic_excluido, id_tipo_calculadora, id_processo) VALUES (5, false, 1, 7);
INSERT INTO gestaoriscos.tb_calculadora(id_calculadora, ic_excluido, id_tipo_calculadora, id_processo) VALUES (6, false, 2, 7);
/*FIM INSERTS TB_CALCULADORA*/

/*INICIO INSERTS tb_impacto_calculadora*/
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (7, 'Valor Orçamentário 2', 26, false, 5, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (8, 'Valor Orçamentário 3', 27, false, 6, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (9, 'Valor Orçamentário 4', 28, false, 5, false);
INSERT INTO gestaoriscos.tb_impacto_calculadora(id_impacto_calculadora, no_impacto_calculadora, nu_peso, ic_excluido, id_calculadora, "ic_desabilitado")
VALUES (10, 'Valor Orçamentário 5', 29, false, 6, false);
/*FIM INSERTS tb_impacto_calculadora*/

/*INICIO INSERTS TB_RESPONSAVEL*/
INSERT INTO "gestaoriscos"."tb_responsavel" ("id_responsavel", "ic_excluido", "id_processo", "id_usuario")
VALUES (1, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_responsavel" ("id_responsavel", "ic_excluido", "id_processo", "id_usuario")
VALUES (2, false, 2, 2);
INSERT INTO "gestaoriscos"."tb_responsavel" ("id_responsavel", "ic_excluido", "id_processo", "id_usuario")
VALUES (3, false, 3, 3);
/*FIM INSERTS TB_RESPONSAVEL*/

/*INICIO INSERTS TB_ARQUIVO_ANEXO*/
INSERT INTO "gestaoriscos"."tb_arquivo_anexo" ("id_arquivo_anexo", "no_arquivo", "no_documento", "fl_conteudo", "dt_upload", "ic_excluido", "nu_tamanho")
VALUES (1, 'Nome Arquivo 1', 'Nome Documento 1', 1, NOW(), false, 1000);
INSERT INTO "gestaoriscos"."tb_arquivo_anexo" ("id_arquivo_anexo", "no_arquivo", "no_documento", "fl_conteudo", "dt_upload", "ic_excluido", "nu_tamanho")
VALUES (2, 'Nome Arquivo 2', 'Nome Documento 2', 1, NOW(), false, 2000);
INSERT INTO "gestaoriscos"."tb_arquivo_anexo" ("id_arquivo_anexo", "no_arquivo", "no_documento", "fl_conteudo", "dt_upload", "ic_excluido", "nu_tamanho")
VALUES (3, 'Nome Arquivo 3', 'Nome Documento 3', 1, NOW(), false, 3000);
/*FIM INSERTS TB_ARQUIVO_ANEXO*/

/*INICIO INSERTS TB_PROCESSO_ANEXO*/
INSERT INTO "gestaoriscos"."tb_processo_anexo" ("id_processo_anexo", "ic_excluido", "id_processo", "id_arquivo_anexo")
VALUES (1, false, 1, 1);
INSERT INTO "gestaoriscos"."tb_processo_anexo" ("id_processo_anexo", "ic_excluido", "id_processo", "id_arquivo_anexo")
VALUES (2, false, 2, 2);
INSERT INTO "gestaoriscos"."tb_processo_anexo" ("id_processo_anexo", "ic_excluido", "id_processo", "id_arquivo_anexo")
VALUES (3, false, 3, 3);
/*FIM INSERTS TB_PROCESSO_ANEXO*/

/*INICIO INSERTS TB_RESPOSTA_RISCO*/
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (1, false, 1, 1, 1, 1);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (2, false, 2, 2, 2, 2);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (3, false, 3, 2, 2, 3);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (4, false, 4, 1, 1, 4);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (5, false, 5, 2, 2, 5);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (6, false, 6, 2, 2, 6);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (7, false, 6, 2, 2, 13);
INSERT INTO "gestaoriscos"."tb_plano_controle" ("id_plano_controle", "ic_excluido", "id_controle", "id_tipo_controle", "id_objetivo_controle", "id_evento_risco")
VALUES (8, false, 2, 1, 1, 15);
/*FIM INSERTS TB_RESPOSTA_RISCO*/

/*INICIO INSERTS TB_PESO_EVENTO_RISCO*/
INSERT INTO "gestaoriscos"."tb_peso_evento_risco" ("id_peso_evento_risco", "nu_peso", "ic_excluido", "id_calculo_risco")
VALUES (1, 1, false, 1);
INSERT INTO "gestaoriscos"."tb_peso_evento_risco" ("id_peso_evento_risco", "nu_peso", "ic_excluido", "id_calculo_risco")
VALUES (2, 2, false, 2);
INSERT INTO "gestaoriscos"."tb_peso_evento_risco" ("id_peso_evento_risco", "nu_peso", "ic_excluido", "id_calculo_risco")
VALUES (3, 3, false, 3);
/*FIM INSERTS TB_PESO_EVENTO_RISCO*/

/*INICIO INSERTS TB_PERMISSAO*/
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (2, 2, 2, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (1, 1, 5, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (3, 3, 4, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (4, 4, 3, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (5, 5, 2, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (6, 6, 1, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (7, 2, 5, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (8, 2, 6, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (9, 5, 6, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (10, 2, 4, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (11, 2, 3, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (12, 2, 1, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (13, 7, 6, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (14, 9, 5, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (15, 9, 6, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (16, 10, 6, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (17, 11, 4, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (18, 11, 5, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (19, 11, 1, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (20, 11, 3, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (21, 12, 5, false, NOW());
INSERT INTO "gestaoriscos"."tb_permissao" ("id_permissao", "id_usuario", "id_perfil", "ic_excluido", "dt_cadastro")
VALUES (22, 12, 6, false, NOW());
/*FIM INSERTS TB_PERMISSAO*/

/*INICIO INSERTS TB_MATRIZ_SWOT*/
INSERT INTO "gestaoriscos"."tb_matriz_swot" ("id_matriz_swot", "ds_matriz_swot", "ic_excluido", "id_analise", "id_tipo_matriz")
VALUES (1, 'Descricao Matriz Swot 1', false, 1, 1);
INSERT INTO "gestaoriscos"."tb_matriz_swot" ("id_matriz_swot", "ds_matriz_swot", "ic_excluido", "id_analise", "id_tipo_matriz")
VALUES (2, 'Descricao Matriz Swot 2', false, 2, 2);
INSERT INTO "gestaoriscos"."tb_matriz_swot" ("id_matriz_swot", "ds_matriz_swot", "ic_excluido", "id_analise", "id_tipo_matriz")
VALUES (3, 'Descricao Matriz Swot 3', false, 3, 3);
/*FIM INSERTS TB_MATRIZ_SWOT*/

/*INICIO INSERTS TB_GLOSSARIO*/
INSERT INTO "gestaoriscos"."tb_glossario" ("id_glossario", "no_glossario", "ds_glossario", "ds_termo_search", "ds_descricao_search", "ic_ativo", "ic_excluido")
VALUES (1, 'Descricao Glossario 1', 'Descricao Glossario 1', 'Descricao Glossario 1', 'Descricao Glossario 1', true, false);
INSERT INTO "gestaoriscos"."tb_glossario" ("id_glossario", "no_glossario", "ds_glossario", "ds_termo_search", "ds_descricao_search", "ic_ativo", "ic_excluido")
VALUES (2, 'Descricao Glossario 2', 'Descricao Glossario 2', 'Descricao Glossario 2', 'Descricao Glossario 2', true, false);
INSERT INTO "gestaoriscos"."tb_glossario" ("id_glossario", "no_glossario", "ds_glossario", "ds_termo_search", "ds_descricao_search", "ic_ativo", "ic_excluido")
VALUES (3, 'Descricao Glossario 3', 'Descricao Glossario 3', 'Descricao Glossario 3', 'Descricao Glossario 3', true, false);
/*FIM INSERTS TB_GLOSSARIO*/
