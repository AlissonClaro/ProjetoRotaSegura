package rotasegura.service;
import rotasegura.dao.Repositorio;
import rotasegura.model.*;
import java.sql.SQLException;
import java.util.Locale;
public class Locadora {
 private final Repositorio repo;
 public Locadora(Repositorio r){repo=r;}
 public java.util.List<Object[]> clientes()throws SQLException{return repo.clientes();}
 public java.util.List<Object[]> veiculos()throws SQLException{return repo.veiculos();}
 public java.util.List<Object[]> locacoes()throws SQLException{return repo.locacoes();}
 public void excluirCliente(String cpf)throws SQLException{repo.excluirCliente(cpf);}
 public void excluirVeiculo(String placa)throws SQLException{repo.excluirVeiculo(placa);}
 public void cancelar(int id)throws SQLException{repo.cancelar(id);}
 public void close()throws SQLException{repo.close();}
 public static String texto(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException("Preencha todos os campos.");return s.trim();}
 public static int dias(String s){int n=Integer.parseInt(s.trim());if(n<=0||n>36500)throw new IllegalArgumentException("Informe dias entre 1 e 36500.");return n;}
 public void cliente(boolean e,String cpf,String nome,String tel)throws SQLException{cpf=texto(cpf).replaceAll("[. -]","");if(!cpf.matches("[0-9]{11}"))throw new IllegalArgumentException("CPF deve conter 11 dígitos.");repo.cliente(e,cpf,texto(nome),texto(tel));}
 public void veiculo(boolean e,String placa,String marca,String modelo,String ano,String cat)throws SQLException{placa=texto(placa).toUpperCase(Locale.ROOT);if(!placa.matches("[A-Z]{3}-?[0-9][A-Z0-9][0-9]{2}"))throw new IllegalArgumentException("Placa inválida.");int a=Integer.parseInt(ano);if(a<1900||a>java.time.Year.now().getValue()+1)throw new IllegalArgumentException("Ano inválido.");repo.veiculo(e,placa,texto(marca),texto(modelo),a,cat);}
 public Veiculo modelo(Object[] v){String p=v[0].toString(),m=v[1].toString(),n=v[2].toString();int a=((Number)v[3]).intValue();switch(v[4].toString()){case "Popular":return new Popular(p,m,n,a);case "Sedan":return new Sedan(p,m,n,a);case "SUV":return new SUV(p,m,n,a);default:throw new IllegalArgumentException("Categoria inválida.");}}
 public double total(String placa,int dias)throws SQLException{return new Locacao(null,modelo(repo.veiculo(placa)),dias).getValorTotal();}
 public void abrir(String cpf,String placa,int dias)throws SQLException{repo.abrir(cpf,placa,dias,total(placa,dias));}
 public void editar(int id,int dias)throws SQLException{repo.editar(id,dias,total(repo.locacao(id)[2].toString(),dias));}
 public void fechar(int id,int dias)throws SQLException{repo.fechar(id,dias,total(repo.locacao(id)[2].toString(),dias));}
 public String resumo(int id,int dias)throws SQLException{Object[] l=repo.locacao(id);double t="FECHADA".equals(l[5])?((Number)l[4]).doubleValue():total(l[2].toString(),dias);return String.format(new Locale("pt","BR"),"ROTA SEGURA — CONTRATO %d\nCPF: %s\nPlaca: %s\nDias: %d\nTotal: R$ %.2f\nStatus: %s\nAbertura: %s\nFechamento: %s",id,l[1],l[2],dias,t,l[5],l[6],l[7]==null?"Pendente":l[7]);}
}
