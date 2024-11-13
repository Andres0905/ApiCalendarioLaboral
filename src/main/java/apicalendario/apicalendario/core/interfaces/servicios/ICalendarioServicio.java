package apicalendario.apicalendario.core.interfaces.servicios;
import java.util.List;

import apicalendario.apicalendario.dominio.Calendario;

public interface ICalendarioServicio {
    
    public List<Calendario> listar(int year);

    void generarCalendarioAnual(int year);

    
}
