package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
public class TipoMatrizTest {

    TipoMatriz tipoMatriz;

    @Before
    public void setUp() throws Exception {
        tipoMatriz = new TipoMatriz();
    }

    @Test
    public void getId() throws Exception {
        tipoMatriz.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), tipoMatriz.getId());
    }

    @Test
    public void getNome() throws Exception {
        tipoMatriz.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoMatriz.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoMatriz.setExcluido(true);
        assertEquals(true, tipoMatriz.isExcluido());
    }

    @Test
    public void getMatrizes() throws Exception {
        MatrizSwot matriSwot = new MatrizSwot();

        List<MatrizSwot> matriSwotList = new ArrayList<>();
        matriSwotList.add(matriSwot);

        tipoMatriz.setMatrizes(matriSwotList);
        assertEquals(matriSwotList, tipoMatriz.getMatrizes());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        TipoMatriz tipoMatriz1 = new TipoMatriz();
        tipoMatriz1.setId(Long.valueOf(1));
        tipoMatriz1.setNome(AnnotationStringUtil.TEST_STRING);
        tipoMatriz1.setExcluido(true);

        TipoMatriz tipoMatriz2 = new TipoMatriz();
        tipoMatriz2.setId(Long.valueOf(2));
        tipoMatriz2.setNome(AnnotationStringUtil.TEST_STRING);
        tipoMatriz2.setExcluido(true);

        assertNotEquals(tipoMatriz1.hashCode(), tipoMatriz2.hashCode());
    }

}