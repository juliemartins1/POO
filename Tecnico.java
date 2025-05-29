public class Tecnico extends Pessoa implements IResponsavel {

    
    public Tecnico(String nome, String cpf, String telefone) {
      super(nome, cpf, telefone);
    }
     
    @Override
    public String toString(){
        return getNome() + " (Cpf: " + getCpf() + ", telefone: " + getTelefone() + " ) ";
    }
    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
public String getDocumento() {
    return getCpf(); 
}

    @Override
    public String getTipoResponsavel() {
        return "Técnico";
    }
   
}