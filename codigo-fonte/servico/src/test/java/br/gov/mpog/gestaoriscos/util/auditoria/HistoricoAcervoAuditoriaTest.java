package br.gov.mpog.gestaoriscos.util.auditoria;

import org.junit.Assert;
import org.junit.Test;

public class HistoricoAcervoAuditoriaTest {
    @Test
    public void equals() throws Exception {
        HistoricoAcervoAuditoria lHistoricoAcervoAuditoria = new HistoricoAcervoAuditoria();
        Assert.assertTrue("Deve ser Igual", lHistoricoAcervoAuditoria.equals(new HistoricoAcervoAuditoria()));

        lHistoricoAcervoAuditoria.setId(0);
        Assert.assertFalse("Não Deve ser Igual", lHistoricoAcervoAuditoria.equals(new HistoricoAcervoAuditoria()));

        lHistoricoAcervoAuditoria.setTimestamp(0L);
        lHistoricoAcervoAuditoria.setId(null);
        Assert.assertFalse("Não Deve ser Igual", lHistoricoAcervoAuditoria.equals(new HistoricoAcervoAuditoria()));
    }

}