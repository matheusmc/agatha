INSERT INTO gestaoriscos.tb_permissao (id_permissao, id_usuario, id_perfil, ic_excluido) VALUES (-99, 1, 5, false);
INSERT INTO gestaoriscos.tb_permissao (id_permissao, id_usuario, id_perfil, ic_excluido) VALUES (-98, 20, 6, false);
-- tb_analise
INSERT INTO gestaoriscos.tb_analise (id_analise, ic_atribuicoes, ic_estrutura, ic_etica, ic_excluido, ic_missao, ic_normas_internas, ic_objetivos, ic_recursos_humanos, ic_visao, id_status_etapa, id_orgao, id_secretaria, id_decisao_etapa, ds_justificativa)
VALUES (-99, true, true, true, false, true, true, true, true, true, 1, 2981, 26, null, null);

--tb_avaliacao
INSERT INTO gestaoriscos.tb_avaliacao (id_avaliacao, ic_excluido, id_status_etapa, ic_ignorar_risco_inerente, id_decisao_etapa, ds_justificativa)
VALUES (-99, false, 2, false, null, null);

--tb_identificacao
INSERT INTO gestaoriscos.tb_identificacao (id_identificacao, ic_excluido, id_status_etapa, id_decisao_etapa, ds_justificativa)
VALUES (-99, false, 2, null, null);

--tb_informacao
INSERT INTO gestaoriscos.tb_informacao (id_informacao, ic_excluido, id_status_etapa, id_decisao_etapa, ds_justificativa)
VALUES (-99, false, 2, null, null);

--tb_resposta
INSERT INTO gestaoriscos.tb_resposta (id_resposta, ic_excluido, id_status_etapa, id_decisao_etapa, ds_justificativa)
VALUES (-99, false, 2, null, null);

--tb_processo
INSERT INTO gestaoriscos.tb_processo (id_processo, no_coordenacao, no_diretoria, dt_fim, dt_inicio, ic_excluido, no_lei, no_macroprocesso,
                                      ds_objetivo, no_processo, no_sistema, id_analise, id_avaliacao, id_usuario, id_identificacao, id_informacao, id_resposta, id_status_processo, ds_search, dt_cadastro)
VALUES (-99, 'teste', 'teste', '2017-06-30 00:00:00.000000', '2017-06-23 00:00:00.000000', false, 'teste', 'teste', 'teste Selenium', 'teste', 'teste', -99, -99, 1, -99, -99, -99, 1, 'teste teste', '2017-06-23 13:16:05.851000');

--tb_responsavel
INSERT INTO gestaoriscos.tb_responsavel (id_responsavel, ic_excluido, id_processo, id_usuario)
VALUES (-99, false, -99, 20);