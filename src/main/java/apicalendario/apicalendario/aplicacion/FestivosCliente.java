package apicalendario.apicalendario.aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import apicalendario.apicalendario.dominio.DTOs.FestivosDto;

@Service
public class FestivosCliente {

    @Autowired
    private RestTemplate restTemplate;

    public List<FestivosDto> obtenerFestivos(Long anio){
            String url = "http://localhost:3030/festivos/listar/" + anio;
            ResponseEntity<List<FestivosDto>> responseEntity = restTemplate.exchange(
        url, 
        HttpMethod.GET, 
        null, 
        new ParameterizedTypeReference<List<FestivosDto>>() {}
    );
    return responseEntity.getBody();
}
}
