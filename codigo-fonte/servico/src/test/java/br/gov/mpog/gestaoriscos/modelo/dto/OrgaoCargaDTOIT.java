package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.modelo.Orgao;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by luizfernando on 25/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class OrgaoCargaDTOIT {

    OrgaoCargaDTO orgaoCarga;

    @Before
    public void setUp() throws Exception {
        orgaoCarga = new OrgaoCargaDTO();
    }

    @Test
    public void getCodigoUnidadeAsLong() throws Exception {
        assertNull(orgaoCarga.getCodigoUnidadeAsLong());
        orgaoCarga.setCodigoUnidade("1");
        assertEquals(Long.valueOf(1), orgaoCarga.getCodigoUnidadeAsLong());
    }

    @Test
    public void getCodigoUnidadePaiAsLong() throws Exception {
        assertNull(orgaoCarga.getCodigoUnidadePaiAsLong());
        orgaoCarga.setCodigoUnidadePai("1");
        assertEquals(Long.valueOf(1), orgaoCarga.getCodigoUnidadePaiAsLong());
    }

    @Test
    public void getCodigoUnidadePaiAsLongNull() throws Exception {
        assertNull(orgaoCarga.getCodigoUnidadePaiAsLong());
        orgaoCarga.setCodigoUnidadePai(null);
        assertEquals(null, orgaoCarga.getCodigoUnidadePaiAsLong());
    }

    @Test
    public void orgaoSemPai() throws Exception {
        orgaoCarga.setCodigoUnidade("1");

        Orgao orgao = orgaoCarga.orgaoSemPai();

        assertEquals(Long.valueOf(1), orgao.getId());
    }

    @Test
    public void orgao() throws Exception {
        orgaoCarga.setCodigoUnidade("1");
        orgaoCarga.setCodigoUnidadePai("1");

        Orgao orgao = orgaoCarga.orgao();

        assertEquals(Long.valueOf(1), orgao.getId());
        assertEquals(Long.valueOf(1), orgao.getOrgaoPai().getId());
    }

    @Test
    public void getCodigoOrgaoEntidadeAsLong() throws Exception {
        assertNull(orgaoCarga.getCodigoOrgaoEntidadeAsLong());
        orgaoCarga.setCodigoOrgaoEntidade("1");
        assertEquals(Long.valueOf(1), orgaoCarga.getCodigoOrgaoEntidadeAsLong());
    }

    @Test
    public void getCodigoCategoriaUnidadeNullAsLong() throws Exception {
        assertEquals(Long.valueOf(0), orgaoCarga.getCodigoCategoriaUnidadeAsLong());
    }

    @Test
    public void getCodigoNaturezaJuridicaAsLong() throws Exception {
        assertNull(orgaoCarga.getCodigoNaturezaJuridicaAsLong());
        orgaoCarga.setCodigoNaturezaJuridica("1");
        assertEquals(Long.valueOf(1), orgaoCarga.getCodigoNaturezaJuridicaAsLong());
    }

    @Test
    public void getCodigoNaturezaJuridicaAsShort() throws Exception {
        assertNull(orgaoCarga.getCodigoNaturezaJuridicaAsShort());
        orgaoCarga.setCodigoNaturezaJuridica("1");
        assertEquals(Short.valueOf("1"), orgaoCarga.getCodigoNaturezaJuridicaAsShort());
    }

    @Test
    public void getCodigoNaturezaJuridicaAsShortNull() throws Exception {
        assertNull(orgaoCarga.getCodigoNaturezaJuridicaAsShort());
        orgaoCarga.setCodigoNaturezaJuridica(null);
        assertEquals(null, orgaoCarga.getCodigoNaturezaJuridicaAsShort());
    }

    @Test
    public void getCodigoSubNaturezaJuridicaAsInt() throws Exception {
        assertNull(orgaoCarga.getCodigoSubNaturezaJuridicaAsInt());
        orgaoCarga.setCodigoSubNaturezaJuridica("1");
        assertEquals(Long.valueOf(1), orgaoCarga.getCodigoSubNaturezaJuridicaAsInt());
    }

    @Test
    public void definirNivel() throws Exception {
        orgaoCarga.definirNivel();
        assertEquals(0 ,orgaoCarga.getNivel());

        OrgaoCargaDTO orgaoPai = new OrgaoCargaDTO();
        orgaoCarga.setPai(orgaoPai);
        orgaoCarga.definirNivel();

        assertEquals(1 ,orgaoCarga.getNivel());

    }

    @Test
    public void compareTo() throws Exception {
        OrgaoCargaDTO orgaoTeste = new OrgaoCargaDTO();

        assertEquals(0, orgaoCarga.compareTo(orgaoTeste));
        orgaoTeste.setNivel(1);
        assertEquals(-1, orgaoCarga.compareTo(orgaoTeste));
        orgaoCarga.setNivel(2);
        assertEquals(1, orgaoCarga.compareTo(orgaoTeste));
    }

    @Test
    public void getAtoNormativo() throws Exception {
        AtoNormativoDTO atoNormativo = new AtoNormativoDTO();

        orgaoCarga.setAtoNormativo(atoNormativo);
        assertEquals(atoNormativo, orgaoCarga.getAtoNormativo());
    }

    @Test
    public void getCodigoCategoriaUnidade() throws Exception {
        orgaoCarga.setCodigoCategoriaUnidade(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoCategoriaUnidade());
    }

    @Test
    public void getCodigoEsfera() throws Exception {
        orgaoCarga.setCodigoEsfera(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoEsfera());
    }

    @Test
    public void getCodigoNaturezaJuridica() throws Exception {
        orgaoCarga.setCodigoNaturezaJuridica(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoNaturezaJuridica());
    }

    @Test
    public void getCodigoOrgaoEntidade() throws Exception {
        orgaoCarga.setCodigoOrgaoEntidade(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoOrgaoEntidade());
    }

    @Test
    public void getCodigoPoder() throws Exception {
        orgaoCarga.setCodigoPoder(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoPoder());
    }

    @Test
    public void getCodigoSubNaturezaJuridica() throws Exception {
        orgaoCarga.setCodigoSubNaturezaJuridica(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoSubNaturezaJuridica());
    }

    @Test
    public void getCodigoTipoUnidade() throws Exception {
        orgaoCarga.setCodigoTipoUnidade(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoTipoUnidade());
    }

    @Test
    public void getCodigoUnidade() throws Exception {
        orgaoCarga.setCodigoUnidade(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoUnidade());
    }

    @Test
    public void getCodigoUnidadePai() throws Exception {
        orgaoCarga.setCodigoUnidadePai(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCodigoUnidadePai());
    }

    @Test
    public void getCompetencia() throws Exception {
        orgaoCarga.setCompetencia(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getCompetencia());
    }

    @Test
    public void getContato() throws Exception {
        ContatoDTO contato = new ContatoDTO();

        List<ContatoDTO> contatoList = new ArrayList<>();
        contatoList.add(contato);

        orgaoCarga.setContato(contatoList);
        assertEquals(contatoList, orgaoCarga.getContato());
    }

    @Test
    public void getDataFinalVersaoConsulta() throws Exception {
        orgaoCarga.setDataFinalVersaoConsulta(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getDataFinalVersaoConsulta());
    }

    @Test
    public void getDataInicialVersaoConsulta() throws Exception {
        orgaoCarga.setDataInicialVersaoConsulta(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getDataInicialVersaoConsulta());
    }

    @Test
    public void getDescricaoAtoNormativo() throws Exception {
        orgaoCarga.setDescricaoAtoNormativo(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getDescricaoAtoNormativo());
    }

    @Test
    public void getEndereco() throws Exception {
        EnderecoDTO endereco = new EnderecoDTO();

        List<EnderecoDTO> enderecoList = new ArrayList<>();
        enderecoList.add(endereco);

        orgaoCarga.setEndereco(enderecoList);
        assertEquals(enderecoList, orgaoCarga.getEndereco());
    }

    @Test
    public void getFinalidade() throws Exception {
        orgaoCarga.setFinalidade(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getFinalidade());
    }

    @Test
    public void getMissao() throws Exception {
        orgaoCarga.setMissao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getMissao());
    }

    @Test
    public void getNivelNormatizacao() throws Exception {
        orgaoCarga.setNivelNormatizacao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getNivelNormatizacao());
    }

    @Test
    public void getNome() throws Exception {
        orgaoCarga.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getNome());
    }

    @Test
    public void getOperacao() throws Exception {
        orgaoCarga.setOperacao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getOperacao());
    }

    @Test
    public void getSigla() throws Exception {
        orgaoCarga.setSigla(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getSigla());
    }

    @Test
    public void getVersaoConsulta() throws Exception {
        orgaoCarga.setVersaoConsulta(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoCarga.getVersaoConsulta());
    }

    @Test
    public void getNivel() throws Exception {
        orgaoCarga.setNivel(1);
        assertEquals(1, orgaoCarga.getNivel());
    }

    @Test
    public void getPai() throws Exception {
        OrgaoCargaDTO orgaoPai = new OrgaoCargaDTO();

        orgaoCarga.setPai(orgaoPai);
        assertEquals(orgaoPai, orgaoCarga.getPai());
    }

    @Test
    public void hashCodeNull() throws Exception {
        OrgaoCargaDTO orgaoCargaDTO = new OrgaoCargaDTO();

        OrgaoCargaDTO orgaoCargaDTO2 = new OrgaoCargaDTO();

        assertEquals(orgaoCargaDTO.hashCode(), orgaoCargaDTO2.hashCode());
    }

    @Test
    public void equals() throws Exception {
        OrgaoCargaDTO orgaoCargaDTO = new OrgaoCargaDTO();
        OrgaoCargaDTO orgaoCargaDTO2 = new OrgaoCargaDTO();

        orgaoCargaDTO.equals(orgaoCargaDTO2);
    }

    @Test
    public void equalsNivelNotEquals() throws Exception {
        OrgaoCargaDTO orgaoCargaDTO = new OrgaoCargaDTO();
        OrgaoCargaDTO orgaoCargaDTO2 = new OrgaoCargaDTO();
        orgaoCargaDTO.setNivel(1);
        orgaoCargaDTO.setNivel(2);
        orgaoCargaDTO.equals(orgaoCargaDTO2);
    }

    @Test
    public void equalsDiferente() throws Exception {
        OrgaoCargaDTO orgaoCargaDTO = new OrgaoCargaDTO();

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        orgaoCargaDTO.equals(avaliacaoDTO);
    }

    @Test
    public void equalsNull() throws Exception {
        OrgaoCargaDTO orgaoCargaDTO = new OrgaoCargaDTO();

        orgaoCargaDTO.equals(null);
    }


}