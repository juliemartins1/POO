import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendaDisponibilidade {
    private Map<LocalDate, List<LocalTime>> agenda = new HashMap<>();

    public void abrirAgenda(LocalDate data) {
        List<LocalTime> horario = new ArrayList<>();
        for (int h = 9; h <= 17; h++) {
            horario.add(LocalTime.of(h, 0));
        }
        agenda.put(data, horario);
    }

    public boolean isDisponivel(LocalDate data, LocalTime hora) {
        List<LocalTime> horarios = agenda.get(data);
        return horarios != null && horarios.contains(hora);
    }

    public void ocuparHorario(LocalDate data, LocalTime hora) throws AgendaNaoDisponivelException {
        if (!isDisponivel(data, hora)) {
            throw new AgendaNaoDisponivelException("Horário não disponível");
        }
        agenda.get(data).remove(hora);
    }

   

}
    
