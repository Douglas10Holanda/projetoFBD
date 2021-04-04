package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AgendarModel;

public class AgendarDAO {
    
    private final Connection connection;
    
    public AgendarDAO(Connection connection){
        this.connection = connection;
    }
    
    private ArrayList<AgendarModel> pesquisa (PreparedStatement statement) throws SQLException{
        
        ArrayList<AgendarModel> agenda = new ArrayList<AgendarModel>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int idAgen = resultSet.getInt("idAge");
            int idCliente = resultSet.getInt("idCliente");
            int idServ = resultSet.getInt("idServ");
            float valor = resultSet.getFloat("valor");
            String data = resultSet.getString("data");
            String obs = resultSet.getString("obs");
            
            AgendarModel agendaComDados = new AgendarModel(idAgen, idCliente, idServ, valor, data, obs);
            agenda.add(agendaComDados);
        }
        
        return agenda;
    }
    
    public void insert(AgendarModel agenda) throws SQLException{
        
        String sql = "insert into agendamento (idCliente, idServ, valor, data, obs) values (?, ?, ?, ?, ?);";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, agenda.getIdCliente());
        statement.setInt(2, agenda.getIdServ());
        statement.setFloat(3, agenda.getValor());
        statement.setString(4, agenda.getData());
        statement.setString(5, agenda.getObs());
        statement.execute();
        
                
    }
    
    public void delete(AgendarModel agenda) throws SQLException{
        
        String sql = "delete from agendamento where idAge = ?;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, agenda.getIdAgen());
        statement.execute();
        
    }
    
    public void update(AgendarModel agenda) throws SQLException{
        
        String sql = "update agendamento set data = ? where idAge = ?;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, agenda.getData());
        statement.setInt(2, agenda.getIdAgen());
        statement.execute();
        
    }
    
    public AgendarModel find(AgendarModel agenda) throws SQLException{
        
        String sql = "select * from agendamento where idAge = ?;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, agenda.getIdAgen());
        
        ArrayList<AgendarModel> agendaD = pesquisa(statement);
        return agendaD.get(0);
        
    }
    
}
