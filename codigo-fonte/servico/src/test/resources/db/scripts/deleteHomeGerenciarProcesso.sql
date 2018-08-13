DELETE FROM gestaoriscos.tb_permissao;

--tb_responsavel
DELETE FROM gestaoriscos.tb_responsavel WHERE id_responsavel = -99;

--tb_processo
DELETE FROM gestaoriscos.tb_processo WHERE id_processo = -99;

--tb_resposta
DELETE FROM gestaoriscos.tb_resposta WHERE id_resposta = -99;

--tb_informacao
DELETE FROM gestaoriscos.tb_informacao WHERE id_informacao = -99;

--tb_identificacao
DELETE FROM gestaoriscos.tb_identificacao WHERE id_identificacao = -99;

--tb_avaliacao
DELETE FROM gestaoriscos.tb_avaliacao WHERE id_avaliacao = -99;

-- tb_analise
DELETE FROM gestaoriscos.tb_analise WHERE id_analise = -99;