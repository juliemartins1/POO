import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {
    private LocalDate dataNascimento;
    private TipoGenero sexo;
    private TipoSanguineo tipoSanguineo;
    private List<Consulta> historicoConsultas = new ArrayList<>();
    private List<Exames> historicoExames = new ArrayList<>();

    public Paciente(String nome, String cpf, String telefone, LocalDate dataNascimento, TipoGenero sexo, TipoSanguineo tipoSanguineo)
 {
        super(nome, cpf, telefone);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoGenero getSexo() {
        return sexo;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void adicionarConsulta(Consulta c) {
        historicoConsultas.add(c);
    }

    public void adicionarExame(Exames e) {
        historicoExames.add(e);
    }

    public List<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public List<Exames> getHistoricoExames() {
        return historicoExames;
    }

    @Override
    public String toString() {
        return getNome() + " (CPF: " + getCpf() + ")";
    }
    
}