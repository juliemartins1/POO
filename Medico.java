import java.time.LocalDate;
import java.time.LocalTime;

public class Medico extends Pessoa implements IResponsavel{

    private String crm;
    private String especialidade;
    private AgendaDisponibilidade agenda = new AgendaDisponibilidade();

    public Medico(String nome, String cpf, String telefone, String crm,String especialidade) {
        super(nome, cpf, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
        
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void abrirAgenda(LocalDate data){
        agenda.abrirAgenda(data);      

    }
    public boolean isDisponivel(LocalDate data, LocalTime hora){
        return agenda.isDisponivel(data, hora);
    }
    public void agendar(LocalDate data, LocalTime hora) throws AgendaNaoDisponivelException {
        agenda.ocuparHorario(data, hora);
    }
    @Override
    public String toString() {
        return getNome() + " (CRM: " + crm + ", Especialidade: " + especialidade + ")";
    }
    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getDocumento() {
        return this.crm;
    }

    @Override
    public String getTipoResponsavel() {
        return "Médico";
    }
}
