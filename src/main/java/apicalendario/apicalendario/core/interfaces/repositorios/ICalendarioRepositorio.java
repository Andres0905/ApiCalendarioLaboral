package apicalendario.apicalendario.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import apicalendario.apicalendario.dominio.Calendario;

@Repository
public interface ICalendarioRepositorio extends JpaRepository<Calendario, Long>{

    @Query("SELECT c FROM Calendario c WHERE EXTRACT(YEAR FROM c.fecha) = :year")
    List<Calendario> listar(@Param("year") int year);

}
