package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClienteModel;
import view.CadastrarClienteView;

public class ClienteDAO {
    
    private final Connection connection;
    
    public ClienteDAO (Connection connection){
        this.connection = connection;
    }
    
    public void insert (ClienteModel cliente) throws SQLException{
        
            String sql = "insert into cliente (nome, cpf, email) values (?, ?, ?);";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEmail());
            statement.execute();
            connection.close();
            
    }
    
}
