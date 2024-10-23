package apicalendario.apicalendario.aplicacion;


import java.util.List;

import org.springframework.stereotype.Service;

import apicalendario.apicalendario.core.interfaces.servicios.IFestivosServicio;
import apicalendario.apicalendario.dominio.DTOs.FestivosDto;

@Service
public class FestivosServicio implements IFestivosServicio{

    private FestivosCliente festivosCliente;

    public FestivosServicio(FestivosCliente festivosCliente){
        this.festivosCliente = festivosCliente;
    }

    @Override
    public List<FestivosDto> obtenerFestivos(Long anio) {
      return festivosCliente.obtenerFestivos(anio);
    }



}
