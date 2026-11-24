package rotasegura;
import rotasegura.dao.Repositorio;import rotasegura.service.Locadora;import rotasegura.gui.Tela;import javax.swing.*;
public class Principal {public static void main(String[] args){SwingUtilities.invokeLater(()->{try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());new java.io.File("dados").mkdirs();new Tela(new Locadora(new Repositorio("jdbc:hsqldb:file:dados/rota"))).setVisible(true);}catch(Exception e){JOptionPane.showMessageDialog(null,e.toString(),"Erro de inicialização",JOptionPane.ERROR_MESSAGE);}});}}
