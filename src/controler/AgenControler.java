package controler;

import dao.AgendarDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AgendarModel;
import view.AgendarView;


public class AgenControler {
    
    private final AgendarView view;
    
    public AgenControler(AgendarView view){
        this.view = view;
    }
    
    
    public void SalvarAgenda(){
        
        
        int idCliente = Integer.parseInt(view.getTxtAGIdCliente().getText());
        int idServ = Integer.parseInt(view.getTxtAGIdServ().getText());
        float valor = Float.parseFloat(view.getTxtAGValor().getText());
        String data = (view.getTxtAGData().getText());
        String obs = view.getTxtAGObs().getText();
        
        AgendarModel agenda = new AgendarModel(idCliente, idServ, valor, data, obs);
        
        try {
            
            Connection conexao = new Conexao().getConnection();
            AgendarDAO agendarDao = new AgendarDAO(conexao);
            agendarDao.insert(agenda);
            JOptionPane.showMessageDialog(null, "Agendado com sucesso!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AgenControler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
