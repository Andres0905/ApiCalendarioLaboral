package apicalendario.apicalendario.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.apicalendario.core.interfaces.servicios.IFestivosServicio;
import apicalendario.apicalendario.dominio.DTOs.FestivosDto;

@RestController
@RequestMapping("/api/calendario")
public class FestivosControlador {

    private IFestivosServicio servicio;

    public FestivosControlador(IFestivosServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/obtener/{anio}", method = RequestMethod.GET)
    public List<FestivosDto> obtener(@PathVariable Long anio) {
        return servicio.obtenerFestivos(anio);
    }


}
