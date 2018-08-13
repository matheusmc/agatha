INSERT INTO gestaoriscos.tb_orgao (id_orgao, no_orgao, id_orgao_superior, sg_orgao, id_categoria_unidade, id_natureza_juridica) VALUES (200000, 'República Federativa do Brasil', null, ' ', 5, null);
INSERT INTO gestaoriscos.tb_orgao (id_orgao, no_orgao, id_orgao_superior, sg_orgao, id_categoria_unidade, id_natureza_juridica) VALUES (200001, 'União', 200000, 'UNIAO', 5, null);
INSERT INTO gestaoriscos.tb_orgao (id_orgao, no_orgao, id_orgao_superior, sg_orgao, id_categoria_unidade, id_natureza_juridica) VALUES (208613, 'Poder Executivo', 200001, 'PE', 5, null);
INSERT INTO gestaoriscos.tb_orgao (id_orgao, no_orgao, id_orgao_superior, sg_orgao, id_categoria_unidade, id_natureza_juridica) VALUES (26, 'Presidência da República', 208613, 'PR', 4, 3);
INSERT INTO gestaoriscos.tb_orgao (id_orgao, no_orgao, id_orgao_superior, sg_orgao, id_categoria_unidade, id_natureza_juridica) VALUES (2981, 'Ministério do Planejamento, Desenvolvimento e Gestão', 26, 'MP', 4, 3);

INSERT INTO gestaoriscos.tb_usuario (id_usuario, no_usuario, nu_cpf, id_orgao) VALUES (1, 'Ryan Correia Dias', '61914509153', 26);
INSERT INTO gestaoriscos.tb_usuario (id_usuario, no_usuario, nu_cpf, id_orgao) VALUES (20, '	Alfredo Bitencourt', '02056685586', 26);

insert into gestaoriscos.tb_permissao(ic_excluido, id_perfil, id_permissao, id_usuario) values (false, 5,3,20);
insert into gestaoriscos.tb_permissao(ic_excluido, id_perfil, id_permissao, id_usuario) values (false, 5,2,1);

