package DLL;

import BLL.Barco;
import java.sql.*;
import java.util.LinkedList;

public class ControllerBarco {
    private static Connection con = Conexion.getInstance().getConnection();

    public static LinkedList<Barco> obtenerBarcosEnPuerto() {
        LinkedList<Barco> barcos = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM barco WHERE fecha_salida IS NULL");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Barco barco = new Barco(
                		  rs.getInt("ID_Barco"),
                          rs.getString("Nombre"),
                          rs.getDouble("Capacidad"),
                          rs.getDate("Fecha_Entrada"),
                          rs.getTime("Hora_Entrada"),
                          rs.getDate("Fecha_Salida"),
                          rs.getTime("Hora_Salida"),
                          rs.getDouble("Tarifa"),
                          rs.getDouble("Impuesto"),
                          rs.getInt("FK_Encargado_de_Barcos")
                );
          
                barcos.add(barco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barcos;
    }

    public static boolean registrarSalida(Barco barco) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE barco SET Fecha_Salida = ?, Hora_Salida = ?, Impuesto = ? WHERE ID_Barco = ?");
            
            stmt.setDate(1, new java.sql.Date(barco.getFechaSalida().getTime()));
            stmt.setTime(2, barco.getHoraSalida());
            stmt.setDouble(3, barco.getImpuesto());
            stmt.setInt(4, barco.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static LinkedList<Barco> obtenerTodosLosBarcos() {
        LinkedList<Barco> barcos = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM barco");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Barco barco = new Barco(
                    rs.getInt("ID_Barco"),
                    rs.getString("Nombre"),
                    rs.getDouble("Capacidad"),
                    rs.getDate("Fecha_Entrada"),
                    rs.getTime("Hora_Entrada"),
                    rs.getDate("Fecha_Salida"),
                    rs.getTime("Hora_Salida"),
                    rs.getDouble("Tarifa"),
                    rs.getDouble("Impuesto"),
                    rs.getInt("FK_Encargado_de_Barcos")
                );
                barcos.add(barco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barcos;
    }
    
    public static boolean registrarBarco(Barco barco) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO barco (Nombre, Capacidad, Fecha_Entrada, Hora_Entrada, Tarifa, FK_Encargado_de_Barcos) " +
                "VALUES (?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, barco.getNombre());
            stmt.setDouble(2, barco.getCapacidad());
            stmt.setDate(3, new java.sql.Date(barco.getFechaEntrada().getTime()));
            stmt.setTime(4, barco.getHoraEntrada());
            stmt.setDouble(5, barco.getTarifa());
            stmt.setInt(6, barco.getFkEncargado());
            
            return stmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    

}