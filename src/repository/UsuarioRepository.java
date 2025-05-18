package repository;

import java.util.List;
import BLL.usuario;

public interface UsuarioRepository {
    void agregarUsuario(usuario usuario);
    List<usuario> mostrarUsuarios();
	<T> T login(String nombre, String password);
}
