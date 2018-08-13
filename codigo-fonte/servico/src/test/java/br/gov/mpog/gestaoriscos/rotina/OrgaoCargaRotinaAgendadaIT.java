package br.gov.mpog.gestaoriscos.rotina;

import br.gov.mpog.gestaoriscos.modelo.dto.CargaStatusDTO;
import br.gov.mpog.gestaoriscos.servico.OrgaosCargaServico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.IntegrationTest;

import java.lang.reflect.Method;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by luizfernando on 22/06/17.
 */
@RunWith(PowerMockRunner.class)
@IntegrationTest("server.port:0")
public class OrgaoCargaRotinaAgendadaIT {

    @InjectMocks
    private OrgaoCargaRotinaAgendada orgaoCargaRotinaAgendada;

    @Mock
    private OrgaosCargaServico servico;

    @Mock
    private CargaStatusDTO cargaStatusDTO;

    @Test
    public void executar() throws Exception {
        when(servico.importarEstruturaOrganizacional()).thenReturn(cargaStatusDTO);

        Method metodo = OrgaoCargaRotinaAgendada.class.getDeclaredMethod("executar");
        metodo.invoke(orgaoCargaRotinaAgendada);
    }

    @Test
    public void executarException() throws Exception {
        when(servico.importarEstruturaOrganizacional()).thenThrow(Exception.class);

        Method metodo = OrgaoCargaRotinaAgendada.class.getDeclaredMethod("executar");
        metodo.invoke(orgaoCargaRotinaAgendada);
    }

}