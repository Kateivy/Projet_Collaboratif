/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author CHAFFORT
 */
public class Database {

    private static Context context;
    private static DataSource source;

    public static Connection getConnection() throws SQLException {
        try {
            if (context == null) {
                context = new InitialContext();
                source = (DataSource) context.lookup("Projet_collaboratif");
            }
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return source.getConnection();
    }
}
