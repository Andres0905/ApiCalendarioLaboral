package apicalendario.apicalendario.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.apicalendario.core.interfaces.servicios.ICalendarioServicio;
import apicalendario.apicalendario.dominio.Calendario;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioControlador {

    @Autowired
    private ICalendarioServicio servicio;

    @GetMapping("/generar/{year}")
    public String generar(@PathVariable int year) {
        List<Calendario> calendarios = servicio.listar(year);
        if (calendarios.isEmpty()) {
            servicio.generarCalendarioAnual(year);
            return "El Calendario del año " + year + " ha sido generado exitosamente.";
        } else {
            return "El calendario para el año " + year + " ya está generado.";
        }
    }

    @RequestMapping(value = "/listar/{year}", method = RequestMethod.GET)
    public List<Calendario> listar(@PathVariable("year") int year) {
        return servicio.listar(year);
    }

}
