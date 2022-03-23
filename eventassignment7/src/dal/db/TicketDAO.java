package dal.db;

import be.Ticket;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class TicketDAO {
    private static SQLServerConnection con;

    String sqlStatement = "SELECT * FROM [EventAssignment].[dbo].[Ticket]";
    Statement statement = con.createStatement();
    ResultSet rs = statement.executeQuery(sqlStatement);

    public TicketDAO() throws SQLException {}


        public  Ticket createTicket(String eventName, String address) {
            try{
                String sqlStatement = "INSERT INTO Ticket (eventName,address) VALUES (?, ?);";
                PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,"eventName");
                statement.setString(2,"address");
                statement.execute();
                ResultSet rs =statement.getGeneratedKeys();
                rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Ticket(eventName,address);
        }
    }

