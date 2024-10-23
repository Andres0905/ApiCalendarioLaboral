package apicalendario.apicalendario.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.apicalendario.core.interfaces.servicios.ICalendarioServicio;
import apicalendario.apicalendario.dominio.Calendario;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioControlador {

    @Autowired
    private ICalendarioServicio servicio;

    @GetMapping("/generar/{year}")
    public String generar(@PathVariable int year) {
        servicio.generarCalendarioAnual(year);
        return "El Calendario del año " + year + " ha sido generado exitosamente";
    }

    @RequestMapping(value = "/listar/{year}", method = RequestMethod.GET)
    public List<Calendario> listar(@PathVariable("year") int year) {
        return servicio.listar(year);
    }

   

}
