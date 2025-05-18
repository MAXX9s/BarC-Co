package GUI;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import BLL.admin;
import BLL.encEnvios;
import BLL.usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usuario max = new usuario("Maxi", "123", LocalDate.of(2005, 9, 25), 2222, "french 2930", "");
		admin nico = new admin("Nico", "111", LocalDate.of(2005, 9, 25), 2222, "french 2930", "nico@davinci.edu.ar", "Admin");
		usuario lucas = new usuario("Luca", "123", LocalDate.of(2005, 9, 25), 2222, "french 2930", "");
		encEnvios encenvio = new encEnvios ("", null, null, 0, null, null);
		
		String[] menu = {
			"Login", "Salir"
		};
		int selec = 0;
		usuario usuarioEncontrado = null;
		
		LinkedList<usuario> usuarios = new LinkedList<>();
		usuarios.add(new admin("Nico", "111", LocalDate.of(2005, 9, 25), 2222, "french 2930", "Administrador", "nico@davinci.edu.ar"));
		usuarios.add(new usuario("Maxi", "123", LocalDate.of(2000, 4, 14), 3333, "french 2930", "Encargado de Barcos"));
		usuarios.add(new usuario("Lucas", "222", LocalDate.of(1999, 11, 10), 4444, "french 2930", "Encargado de Envios"));

		do {
			selec = JOptionPane.showOptionDialog(
				null,
				"Bienvenido a la Empresa \n           Bar.Co",
				"",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(Main.class.getResource("/img/puerto2.png")),
				menu,
				menu[0]
			);

			switch (selec) {
				case 0:
					max.Login("", "", null);
					
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Que tengas un Buen dia!!!  :)");
					break;
			}

		} while (selec != 1);
	}
}


