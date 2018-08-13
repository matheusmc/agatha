package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Perfil;
import br.gov.mpog.gestaoriscos.modelo.Permissao;
import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.modelo.dto.PerfilDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoContainerDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.UsuarioDTO;
import br.gov.mpog.gestaoriscos.repositorio.PerfilRepository;
import br.gov.mpog.gestaoriscos.repositorio.PermissaoCustomRepositorio;
import br.gov.mpog.gestaoriscos.repositorio.PermissaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.UsuarioRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.OrgaoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.UsuarioCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.PermissaoServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.PerfilMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.PermissaoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.UsuarioMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Stubber;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.*;

/**
 * Created by matheusbarbosa on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PermissaoServiceTest {

    private static final Long ID = 1L;
    private static final String NOME = "NOME";
    private static final String DESCRICAO = "DESCRICAO";
    private static final Long ORGAO = 2L;

    @InjectMocks
    private PermissaoServiceImpl permissaoService;

    @Mock
    private PermissaoRepository permissaoRepository;

    @Mock
    private PerfilRepository perfilRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock
    private PermissaoCustomRepositorio permissaoCustomRepositorio;

    @Mock
    private UsuarioCustomRepositorioImpl usuarioCustomRepositorio;

    @Mock
    private OrgaoCustomRepositorioImpl orgaoCustomRepositorio;

    @Mock
    private PermissaoMapper permissaoMapper;

    @Mock
    private PerfilMapper perfilMapper;

    @Mock
    private List<Perfil> perfils;

    @Mock
    private List<PerfilDTO> perfilDTOs;

    @Mock
    private PermissaoContainerDTO permissaoContainerDTO;

    @Mock
    private Usuario usuario;

    @Mock
    private UsuarioDTO usuarioDTO;

    @Mock
    private Permissao permissao;

    @Mock
    private PermissaoDTO permissaoDTO;

    @Mock
    private List<PermissaoDTO> permissaoDTOs;

    @Mock
    private Page<UsuarioDTO> usuarioDTOPage;

    @Mock
    private Page<Usuario> usuarioPage;

    @Mock
    private Pageable pageable;

    @Before
    public void setUp(){
        List<String> descricoes = new ArrayList<>();
        when(usuarioCustomRepositorio.searchByDescricao(DESCRICAO)).thenReturn(descricoes);
        when(orgaoCustomRepositorio.searchByNome(DESCRICAO)).thenReturn(descricoes);
        when(perfilRepository.findAll()).thenReturn(perfils);
        when(perfilMapper.perfilsToPerfilDTOs(perfils)).thenReturn(perfilDTOs);
    }

    @Test
    public void searchUsuarioByNome() throws Exception {
        List<String> nomeList = permissaoService.searchUsuarioByNome(NOME);
        assertNotNull(nomeList);
    }

    @Test
    public void searchOrgaoByNome() throws Exception {
        List<String> nomeList = permissaoService.searchOrgaoByNome(NOME);
        assertNotNull(nomeList);
    }

    @Test
    public void findAllPerfils() throws Exception {
        List<PerfilDTO> perfilDTOs = permissaoService.findAllPerfils();
        assertNotNull(perfilDTOs);
    }

    @Test
    public void saveList() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(ID);

        Perfil perfil = new Perfil();
        perfil.setId(ID);

        Permissao newPermissao = new Permissao(permissao);

        newPermissao.setUsuario(usuario);
        newPermissao.setPerfil(perfil);

        List<Permissao> permissaos = new ArrayList<>();
        permissaos.add(newPermissao);

        when(permissaoContainerDTO.getPermissaos()).thenReturn(permissaoDTOs);
        when(permissaoMapper.permissaoDTOsToPermissaos(permissaoDTOs)).thenReturn(permissaos);
        when(permissaoRepository.findByUsuarioIdAndPerfilId(ID, ID)).thenReturn(newPermissao);

        permissaoService.saveList(permissaoContainerDTO);
    }

    @Test
    public void saveListWhenPermissaoPermitedIsNull() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(ID);

        Perfil perfil = new Perfil();
        perfil.setId(ID);

        Permissao newPermissao = new Permissao(permissao);

        newPermissao.setUsuario(usuario);
        newPermissao.setPerfil(perfil);

        List<Permissao> permissaos = new ArrayList<>();
        permissaos.add(newPermissao);

        when(permissaoContainerDTO.getPermissaos()).thenReturn(permissaoDTOs);
        when(permissaoMapper.permissaoDTOsToPermissaos(permissaoDTOs)).thenReturn(permissaos);
        when(permissaoRepository.findByUsuarioIdAndPerfilId(ID, ID)).thenReturn(null);
        when(perfilRepository.findOne(ID)).thenReturn(perfil);
        when(usuarioRepository.findOne(ID)).thenReturn(usuario);
        when(permissaoRepository.save(permissaos)).thenReturn(anyListOf(Permissao.class));

        permissaoService.savePermissaoList(permissaoDTOs);
    }



    @Test
    public void save() throws Exception {
        when(permissaoMapper.permissaoDTOToPermissao(this.permissaoDTO)).thenReturn(permissao);
        when(permissaoRepository.save(permissao)).thenReturn(permissao);

        PermissaoDTO permissaoDTO = permissaoService.save(this.permissaoDTO);
        assertNotNull(permissaoDTO);
    }

    @Test
    public void findAll() throws Exception {
        when(permissaoCustomRepositorio.listarPermissaos(pageable, NOME, ID, ORGAO)).thenReturn(usuarioPage);
        when(usuarioPage.map(any(Converter.class))).thenReturn(usuarioDTOPage);
        when(usuarioMapper.usuarioToUsuarioDTO(any(Usuario.class))).thenReturn(usuarioDTO);

        Page<UsuarioDTO> usuarioDTOs = permissaoService.findAll(NOME, ID, ORGAO, pageable);
        assertNotNull(usuarioDTOs);
    }

    @Test
    public void findOne() throws Exception {
        when(permissaoRepository.findOne(ID)).thenReturn(permissao);

        PermissaoDTO permissaoDTO = permissaoService.findOne(ID);
        assertNotNull(permissaoDTO);
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(permissaoRepository).deletePermissaoById(1L);
        permissaoService.delete(ID);
        verify(permissaoRepository).deletePermissaoById(1L);
    }

    @Test
    public void doNotdeleteWhenIdIsNull() throws Exception {
        doNothing().when(permissaoRepository).deletePermissaoById(1L);
        permissaoService.delete(null);
        verify(permissaoRepository, never()).deletePermissaoById(1L);
    }

    @Test
    public void verificarExistenciaWhenPermissaoPersistedIsNull() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        usuarioDTO.setId(ID);

        PerfilDTO perfilDTO = new PerfilDTO(ID, NOME);
        perfilDTO.setId(ID);

        PermissaoDTO newPermissaoDTO = new PermissaoDTO(permissao);

        newPermissaoDTO.setUsuario(usuarioDTO);
        newPermissaoDTO.setPerfil(perfilDTO);

        when(permissaoRepository.findByUsuarioIdAndPerfilId(ID, ID)).thenReturn(null);

        Boolean existencia = permissaoService.verificarExistencia(newPermissaoDTO);
        assertNotNull(existencia);
    }

    @Test
    public void verificarExistenciaWhenPermissaoPersistedIsTrue() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        usuarioDTO.setId(ID);

        PerfilDTO perfilDTO = new PerfilDTO(ID, NOME);
        perfilDTO.setId(ID);

        PermissaoDTO newPermissaoDTO = new PermissaoDTO(permissao);

        newPermissaoDTO.setUsuario(usuarioDTO);
        newPermissaoDTO.setPerfil(perfilDTO);

        when(permissaoRepository.findByUsuarioIdAndPerfilId(ID, ID)).thenReturn(permissao);

        Boolean existencia = permissaoService.verificarExistencia(newPermissaoDTO);
        assertNotNull(existencia);
    }

    @Test
    public void verificarExistenciaWhenPermissaoPersistedIsTrueAndNotEqualsToPermissaoDTO() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        usuarioDTO.setId(ID);

        PerfilDTO perfilDTO = new PerfilDTO(ID, NOME);
        perfilDTO.setId(ID);

        PermissaoDTO newPermissaoDTO = new PermissaoDTO(permissao);

        newPermissaoDTO.setUsuario(usuarioDTO);
        newPermissaoDTO.setPerfil(perfilDTO);

        newPermissaoDTO.setId(ID);

        when(permissaoRepository.findByUsuarioIdAndPerfilId(ID, ID)).thenReturn(permissao);

        Boolean existencia = permissaoService.verificarExistencia(newPermissaoDTO);
        assertNotNull(existencia);
    }

}
