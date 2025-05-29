import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Criando pacientes
        Paciente paciente1 = new Paciente(
            "João", "98765432100", "53988888888",
            LocalDate.of(1991, 10, 13),
            TipoGenero.MASCULINO, TipoSanguineo.A_positivo
        );

       
        // 2. Criando médicos e abrindo agenda
        Medico medico1 = new Medico("Carla", "12345678900", "53999999999", "CRM1234", "Cardiologia");
        medico1.abrirAgenda(LocalDate.of(2025, 6, 1));

        
        try {
            // 3. Agendando consultas
            LocalDateTime dataHora = LocalDateTime.of(2025, 6, 1, 10, 0);
            medico1.agendar(dataHora.toLocalDate(), dataHora.toLocalTime());
            Consulta consulta1 = new Consulta(dataHora, TipoConsulta.ROTINA, medico1, paciente1);
            paciente1.adicionarConsulta(consulta1);

        

            // 4. Encerrando consultas
            consulta1.realizar("Consulta finalizada", "Dor no peito", "ECG", "AAS 100mg");

           
            // 5. Criando técnico e marcando exame
            Tecnico tecnico = new Tecnico("Pedro", "11122233344", "53998887777");

            System.out.println("=== Informações do Responsável pelo Exame ===");
            IResponsavel responsavel = tecnico; 
            System.out.println("Nome: " + responsavel.getNome());
            System.out.println("CPF: " + responsavel.getDocumento());
            System.out.println("Tipo: " + responsavel.getTipoResponsavel());
            LocalDateTime dataExame = LocalDateTime.of(2025, 6, 1, 14, 0);
            Exames exame = new Exames("ECG", dataExame, tecnico,paciente1);
            paciente1.adicionarExame(exame);
            exame.encerrarExame("Sem problemas cardíacos");

            // 6. Exibindo histórico
            System.out.println("=== Histórico do Paciente===");
            for (Consulta c : paciente1.getHistoricoConsultas()) {
                System.out.println("nome paciente: "+ paciente1.getNome()+"\n- Consulta em: " + c.agendar());
            }
            

                System.out.println("=== Exames ===");
            for (Exames e : paciente1.getHistoricoExames()) {
                System.out.println("Nome: " +paciente1.getNome());
                System.out.println("- Exame: " + e.agendar());
                System.out.println("  Laudo: " + e.getLaudo());
            }

            // 7. Prontuários
         
            
            System.out.println("=== Prontuário Paciente ===");
            System.out.println("Nome: " + paciente1.getNome());
            exibirProntuario(consulta1.getProntuario());

          
        } catch (AgendaNaoDisponivelException e) {
            System.out.println("Erro ao agendar: " + e.getMessage());
        }
    }

    // Método auxiliar para exibir prontuários
    public static void exibirProntuario(Prontuario p) {
        if (p != null) {
            System.out.println("Paciente: " + p.getPaciente().getNome());
            System.out.println("Médico: " + p.getMedico().getNome());
            System.out.println("Detalhes: " + p.getDetalhes());
            System.out.println("Sintomas: " + p.getSintomas());
            System.out.println("Exames Solicitados: " + p.getExameSolicitados());
            System.out.println("Medicamentos: " + p.getMedicamentos());
        }
    }
}
