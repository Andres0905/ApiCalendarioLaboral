package apicalendario.apicalendario.aplicacion;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import apicalendario.apicalendario.dominio.DTOs.EsFestivoDto;

@Service
public class EsFestivoCliente {

    @Autowired
    private RestTemplate restTemplate;

    public EsFestivoDto verificarFestivo(LocalDate fecha) {
        String url = "http://localhost:3030/festivos/verificar/{year}/{month}/{day}";
        Map<String, Object> params = new HashMap<>();
        params.put("year", fecha.getYear());
        params.put("month", fecha.getMonthValue());
        params.put("day", fecha.getDayOfMonth());

        try {
            
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class,
                params
            );

            String resultado = responseEntity.getBody();

            
            EsFestivoDto esFestivoDto = new EsFestivoDto();
            if ("Es Festivo".equalsIgnoreCase(resultado)) {
                esFestivoDto.setEsfestivo("si");
            } else {
                esFestivoDto.setEsfestivo("no");
            }

            return esFestivoDto;

        } catch (RestClientException e) {
            System.err.println("Error al llamar a la API de festivos: " + e.getMessage());
            throw new RuntimeException("Error al comunicarse con la API de festivos", e);
        }
    }
}