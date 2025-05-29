
import java.time.LocalDateTime;

public class Consulta implements IAgendavel {

    private LocalDateTime dataHora;
    private Medico medico;
    private TipoConsulta tipo;
    private Paciente paciente;
    private Prontuario prontuario;

    public Consulta(LocalDateTime dataHora, TipoConsulta tipo, Medico medico, Paciente paciente){

        this.dataHora = dataHora;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente= paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    

    
    @Override
    public String agendar() {
        return "Paciente:" + paciente +  "\nconsulta do tipo:" + tipo + "\nagenda para: " + dataHora 
        + "\nmedico: " + medico;
        }
        
        public void encerrarConsulta(Paciente paciente, Medico medico, String detalhes, String sintomas, String examesSolicitados, String medicamento) {
            this.prontuario = new Prontuario(paciente, medico, detalhes, sintomas, examesSolicitados, medicamento);
        }

        public void exibirProntuario() {
        if (prontuario != null) {
            System.out.println("Prontuário da consulta:");
            System.out.println(prontuario);
        } else {
            System.out.println("Consulta ainda não encerrada. Prontuário indisponível.");
        }
    }
    @Override
    public LocalDateTime getDataHora() {
    
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public TipoConsulta getTipo() {
        return tipo;
    }
    public void setTipo(TipoConsulta tipo) {
        this.tipo = tipo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Prontuario getProntuario() {
        return prontuario;
    }
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    @Override

    public void realizar() {
        System.out.println("Use o método realizar(detalhes, sintomas, exames, medicamento) para registrar a consulta.");
    }
    public void realizar(String detalhes, String sintomas, String examesSolicitados, String medicamento) {
        encerrarConsulta(this.paciente, this.medico, detalhes, sintomas, examesSolicitados, medicamento);

    }
       }

