public class Prontuario {
    private Paciente paciente;
    private Medico medico;
    private String detalhes;
    private String sintomas;
    private String exameSolicitados;
    private String medicamentos;

    public Prontuario(Paciente paciente, Medico medico, String detalhes, String sintomas, String examesSolicitados, String medicamentos) {
        this.paciente = paciente;
        this.medico = medico;
        this.detalhes = detalhes;
        this.sintomas = sintomas;
        this.exameSolicitados = examesSolicitados;
        this.medicamentos = medicamentos;
    }
    
    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getExameSolicitados() {
        return exameSolicitados;
    }

    public void setExameSolicitados(String exameSolicitados) {
        this.exameSolicitados = exameSolicitados;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public Medico getMedico() {
        return medico;
    }
    
    public static void exibirProntuario(Prontuario p) {
        if (p != null) {
            System.out.println("Detalhes: " + p.getDetalhes());
            System.out.println("Sintomas: " + p.getSintomas());
            System.out.println("Exames Solicitados: " + p.getExameSolicitados());
            System.out.println("Medicamentos: " + p.getMedicamentos());
        }
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente + "\n" +
               "Médico Responsável: " + medico + "\n" +
               "Sintomas: " + sintomas + "\n" +
               "Exames Solicitados: " + exameSolicitados + "\n" +
               "Medicamentos: " + medicamentos;
    }
  
}
