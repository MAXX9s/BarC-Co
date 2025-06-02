package repository;

import java.util.List;
import BLL.usuario;

public interface UsuarioRepository {
    void agregarUsuario(usuario usuario);
    List<usuario> mostrarUsuarios();
	
}
