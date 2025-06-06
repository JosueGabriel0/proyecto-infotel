package pe.edu.upeu.infotelspringboot.service;

import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.infotelspringboot.model.dto.UsuarioCompletoDto;
import pe.edu.upeu.infotelspringboot.model.entity.Usuario;

import java.util.List;

public interface UsuarioCompletoService {
    public List<Usuario> listarUsuarioCompleto();
    public Usuario buscarUsuarioCompletoPorId(Long idUsuario);
    public Usuario crearUsuarioCompleto(UsuarioCompletoDto usuarioCompleto, MultipartFile file);
    public Usuario actualizarUsuarioCompleto(Long idUsuario, UsuarioCompletoDto usuarioCompleto, MultipartFile file);
    public void eliminarUsuarioCompleto(Long idUsuario);
    List<Usuario> buscarUsuariosPorUsername(String username);
}
