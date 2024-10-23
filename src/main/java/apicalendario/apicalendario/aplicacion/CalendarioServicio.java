package apicalendario.apicalendario.aplicacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicalendario.apicalendario.core.interfaces.repositorios.ICalendarioRepositorio;
import apicalendario.apicalendario.core.interfaces.repositorios.ITipoRepositorio;
import apicalendario.apicalendario.core.interfaces.servicios.ICalendarioServicio;
import apicalendario.apicalendario.dominio.Calendario;
import apicalendario.apicalendario.dominio.Tipo;
import apicalendario.apicalendario.dominio.DTOs.EsFestivoDto;

@Service
public class CalendarioServicio implements ICalendarioServicio {

    private ICalendarioRepositorio repositorio;
    private EsFestivoCliente esFestivoCliente;
    private ITipoRepositorio tipoRepositorio;

    @Autowired
    public CalendarioServicio(ICalendarioRepositorio repositorio, EsFestivoCliente esFestivoCliente, ITipoRepositorio tipoRepositorio) {
        this.repositorio = repositorio;
        this.esFestivoCliente = esFestivoCliente;
        this.tipoRepositorio = tipoRepositorio;
    }

    @Override
    public void generarCalendarioAnual(int year) {
        List<Calendario> calendarioList = new ArrayList<>();
    
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
    
        
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            Tipo tipo = determinarTipoDia(date); 
            Calendario calendario = new Calendario();
            calendario.setFecha(java.sql.Date.valueOf(date));
            calendario.setTipo(tipo);     
          
            String diaDeLaSemana;
            switch (date.getDayOfWeek()) {
                case MONDAY -> diaDeLaSemana = "Lunes";
                case TUESDAY -> diaDeLaSemana = "Martes";
                case WEDNESDAY -> diaDeLaSemana = "Miércoles";
                case THURSDAY -> diaDeLaSemana = "Jueves";
                case FRIDAY -> diaDeLaSemana = "Viernes";
                case SATURDAY -> diaDeLaSemana = "Sábado";
                case SUNDAY -> diaDeLaSemana = "Domingo";
                default -> throw new IllegalStateException("Día inválido: " + date.getDayOfWeek());
            }
    
           
            calendario.setDescripcion(diaDeLaSemana);
    
            calendarioList.add(calendario); 
        }
    
        repositorio.saveAll(calendarioList); 
    }

    private Tipo determinarTipoDia(LocalDate date) {
        
        EsFestivoDto festivoResponse = esFestivoCliente.verificarFestivo(date);
    
        Tipo tipo;
        if ("si".equalsIgnoreCase(festivoResponse.getEsfestivo())) {
            tipo = tipoRepositorio.findById(3).orElseThrow(() -> new RuntimeException("Tipo festivo no encontrado"));
        } else if (date.getDayOfWeek().getValue() >= 6) { 
            tipo = tipoRepositorio.findById(2).orElseThrow(() -> new RuntimeException("Tipo fin de semana no encontrado"));
        } else {
            tipo = tipoRepositorio.findById(1).orElseThrow(() -> new RuntimeException("Tipo laboral no encontrado"));
        }
    
        return tipo;
    }

    @Override
    public List<Calendario> listar(int year) {
        return repositorio.listar(year);
    }

}