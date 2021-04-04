package controler;

import dao.AgendarDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AgendarModel;
import view.RemoverAgendamentoView;

public class RAgenControler {

private final RemoverAgendamentoView view;

    public RAgenControler(RemoverAgendamentoView view){
        this.view = view;
    }
    
    public void RemoverAgendamento() throws SQLException{
        
        int idAgen = Integer.parseInt(view.getTxtRemAgen().getText());
        
        AgendarModel removeAgenda = new AgendarModel(idAgen);
        
        try {
            
            Connection conexao = new Conexao().getConnection();
            AgendarDAO agendarDao = new AgendarDAO(conexao);
            agendarDao.delete(removeAgenda);
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AgenControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
