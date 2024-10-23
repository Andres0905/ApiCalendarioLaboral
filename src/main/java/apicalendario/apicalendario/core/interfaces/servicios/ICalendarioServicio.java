package apicalendario.apicalendario.core.interfaces.servicios;
import apicalendario.apicalendario.dominio.Calendario;

import java.util.List;

public interface ICalendarioServicio {
    
    public List<Calendario> listar(int year);

    void generarCalendarioAnual(int year);

    
  
}
