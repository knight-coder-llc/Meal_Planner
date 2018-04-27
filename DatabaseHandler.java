
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class DatabaseHandler {

    Connection conn = null;
    
    //makes connection to database
    public static Connection setupConnection(){

        String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
        String jdbcURL = "jdbc:oracle:thin:@cswinserv.eku.edu:1521:cscdb";        
        String username = "koger5452018";
        String password = "3053";
        
        try {
            //load jdbc driver
            Class.forName(jdbcDriver);          
            //connect to db
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            return conn;
        }catch(Exception e){

        JOptionPane.showMessageDialog(null, e);
        }

    return null;

    }

    static void close(Connection conn) 
    {
        if(conn != null) 

        {
            try

            {
                conn.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    static void close(OraclePreparedStatement st)
    {
        if(st != null)
        {
            try
            {
                st.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    static void close(OracleResultSet rs)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(Throwable whatever)

            {}
        }
    }

    //this method will insert a recipe into the database

    static void insertRecipe(String n, String i, String c){

        Connection conn = DatabaseHandler.setupConnection();
        OraclePreparedStatement pst = null;

        try
        {           
            String sqlStatement = "insert into recipe values (seq_recipe.nextval, ? , ? , ?)";            

            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);            
            pst.setString(1, n);
            pst.setString(2, i);
            pst.setString(3, c);
            pst.execute();                                    

        }

        catch (Exception e)

        {
            JOptionPane.showMessageDialog(null, e);
        }

        finally

        {
            
            DatabaseHandler.close(pst);
            DatabaseHandler.close(conn);
        }
    }

    //this method will insert an ingredent into the database

    static void insertIngredient(String n, int calories, int fat, int sodium, 

            String group, int proteins, int sugar){

        Connection conn = DatabaseHandler.setupConnection();

        OraclePreparedStatement pst = null;

        try

        {           

            String sqlStatement = "insert into ingredients values (?, ?, ?, ?, ?, ?, ?)";            

            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);            

            pst.setString(1, n);
            pst.setInt(2, calories);
            pst.setInt(3, fat);
            pst.setInt(4, sodium);
            pst.setString(5, group);
            pst.setInt(6, proteins);
            pst.setInt(7, sugar);
            pst.execute();                                    

        }

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {            
            DatabaseHandler.close(pst);
            DatabaseHandler.close(conn);
        } 
    }
}