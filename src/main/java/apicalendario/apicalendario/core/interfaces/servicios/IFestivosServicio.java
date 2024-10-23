package apicalendario.apicalendario.core.interfaces.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apicalendario.apicalendario.dominio.DTOs.FestivosDto;

@Service
public interface IFestivosServicio {

    List<FestivosDto> obtenerFestivos(Long anio);

}
