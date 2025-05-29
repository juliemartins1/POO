import java.time.LocalDateTime;

public class Exames implements IAgendavel {

    private String nome;
    private LocalDateTime dataHora;
    private IResponsavel responsavel;
    private Paciente paciente;
    private String laudo;
    private boolean realizado = false;

    
    public Exames(String nome, LocalDateTime dataHora, IResponsavel responsavel, Paciente paciente) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.responsavel = responsavel;
        this.paciente = paciente;
    }

    public String getNome() {
        return nome;
    }

    public IResponsavel getResponsavel() {
        return responsavel;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }
    

    @Override
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public void realizar() {
        if (!realizado) {
            realizar("Laudo não informado");
        }
    }

    public void realizar(String laudo) {
        this.laudo = laudo;
        this.realizado = true;
        paciente.adicionarExame(this); 
    }

    @Override
    public String agendar() {
        return "Exame agendado: " + nome + " para " + paciente.getNome() + " em " + dataHora.toString();
    }

    public void encerrarExame(String laudo) {
        this.laudo = laudo;
    }

    public String getLaudo() {
        return this.laudo;
    }
}
