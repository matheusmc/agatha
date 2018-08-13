package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.*;
import br.gov.mpog.gestaoriscos.modelo.dto.CalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoCalculadoraDTO;
import br.gov.mpog.gestaoriscos.repositorio.CalculadoraRepository;
import br.gov.mpog.gestaoriscos.repositorio.TipoCalculadoraRepository;
import br.gov.mpog.gestaoriscos.servico.impl.CalculadoraServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.CalculadoraMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.TipoCalculadoraMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

/**
 * Created by matheusbarbosa on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculadoraServiceTest {

    @InjectMocks
    private CalculadoraServiceImpl calculadoraService;

    @Mock
    private CalculadoraRepository calculadoraRepository;

    @Mock
    private CalculadoraMapper calculadoraMapper;

    @Mock
    private TipoCalculadoraMapper tipoCalculadoraMapper;

    @Mock
    private CalculadoraDTO calculadoraDTO;

    @Mock
    private Calculadora calculadora;

    @Mock
    private TipoCalculadoraRepository tipoCalculadoraRepository;

    @Mock
    private List<TipoCalculadoraDTO> tipoCalculadoraDTOs;

    @Mock
    private List<TipoCalculadora> tipoCalculadoras;

    @Mock
    private ImpactoCalculadora impactoCalculadora;

    @Mock
    private ProbabilidadeCalculadora probabilidadeCalculadora;

    @Mock
    private Processo processo;

    @Before
    public void setUp(){
        when(calculadoraRepository.save(any(Calculadora.class))).thenReturn(calculadora);
        when(calculadoraMapper.calculadoraToCalculadoraDTO(any(Calculadora.class))).thenReturn(calculadoraDTO);
        when(tipoCalculadoraMapper.tipoCalculadorasToTipoCalculadoraDTOs(anyListOf(TipoCalculadora.class))).thenReturn(tipoCalculadoraDTOs);
        when(tipoCalculadoraRepository.findAll()).thenReturn(tipoCalculadoras);
    }

    @Test
    public void saveWhenListEmpty() {
        when(calculadoraMapper.calculadoraDTOToCalculadora(calculadoraDTO)).thenReturn(calculadora);
        when(calculadoraRepository.save(calculadora)).thenReturn(calculadora);
        when(calculadoraMapper.calculadoraToCalculadoraDTO(calculadora)).thenReturn(calculadoraDTO);

        CalculadoraDTO calculadoraDTO = calculadoraService.save(this.calculadoraDTO);
        assertNotNull(calculadoraDTO);
    }

    @Test
    public void saveWhenImpactoCalculadoraAndProbabilidadeCalculadoraHasValue() throws Exception {
        List<ImpactoCalculadora> impactoCalculadoras = new ArrayList<>();
        impactoCalculadoras.add(impactoCalculadora);

        List<ProbabilidadeCalculadora> probabilidadeCalculadoras = new ArrayList<>();
        probabilidadeCalculadoras.add(probabilidadeCalculadora);



        Calculadora newCalculadora = new Calculadora(calculadora, processo);

        newCalculadora.setImpactos(impactoCalculadoras);
        newCalculadora.setProbabilidades(probabilidadeCalculadoras);


        when(calculadoraMapper.calculadoraDTOToCalculadora(this.calculadoraDTO)).thenReturn(newCalculadora);

        CalculadoraDTO calculadoraDTO = calculadoraService.save(this.calculadoraDTO);
        assertNotNull(calculadoraDTO);
    }

    @Test
    public void findAllTiposCalculadora() throws Exception {
        List<TipoCalculadoraDTO> tiposCalculadoraDTOs = calculadoraService.findAllTiposCalculadora();
        assertNotNull(tiposCalculadoraDTOs);
    }

    @Test
    public void findAll() throws Exception {
        List<CalculadoraDTO> calculadoraDTOs = calculadoraService.findAll();
        assertNotNull(calculadoraDTOs);
    }

}
