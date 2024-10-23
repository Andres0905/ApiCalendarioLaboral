package apicalendario.apicalendario.aplicacion;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import apicalendario.apicalendario.core.interfaces.servicios.IEsFestivoServicio;
import apicalendario.apicalendario.dominio.DTOs.EsFestivoDto;

@Service
public class EsFestivoServicio implements IEsFestivoServicio {

    private final EsFestivoCliente esFestivoCliente;

    public EsFestivoServicio(EsFestivoCliente esFestivoCliente) {
        this.esFestivoCliente = esFestivoCliente;
    }

    @Override
    public EsFestivoDto verificarFestivo(String esfestivo) {
        try {
            LocalDate fecha = LocalDate.parse(esfestivo);
            return esFestivoCliente.verificarFestivo(fecha);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto, usa 'YYYY-MM-DD'.", e);
        }
    }
}