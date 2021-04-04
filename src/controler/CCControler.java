package controler;

import dao.ClienteDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ClienteModel;
import view.CadastrarClienteView;

public class CCControler {
    
    private final CadastrarClienteView view;
    
    public CCControler(CadastrarClienteView view){
        this.view = view;
    }
    
    public void SalvarCliente(){
 
        String nome = view.getTxtNomeC().getText();
        String cpf = view.getTxtCpfC().getText();
        String email = view.getTxtEmailC().getText();
        
        ClienteModel cliente = new ClienteModel(nome, cpf, email);
        
        try {
            
            Connection conexao = new Conexao().getConnection();
            ClienteDAO clienteDao = new ClienteDAO(conexao);
            clienteDao.insert(cliente);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
