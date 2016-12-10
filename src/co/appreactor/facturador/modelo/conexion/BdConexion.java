/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.conexion;

import co.appreactor.facturador.negocio.constantes.EMensajes;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lord_Nightmare
 */
public final class BdConexion {
    
    public static Connection conectar() throws FacturadorException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/facturador_db",
                    "root",
                    "1234"
            );
            cnn.setAutoCommit(false);
            return cnn;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new FacturadorException(EMensajes.ERROR_CONEXION_BD);
        }        
    }
    
    public static void desconectar(PreparedStatement ps){
        desconectar(null, ps);
    }
    
    public static void desconectar(Connection cnn){
        desconectar(cnn, null);
    }
    
    private static void desconectar(Connection cnn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
                return;
            }
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    public static void rollback(Connection cnn){
        try {
            cnn.rollback();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
}
