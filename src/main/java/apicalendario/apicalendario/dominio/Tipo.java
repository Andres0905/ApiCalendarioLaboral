package apicalendario.apicalendario.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tipo")
public class Tipo {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "tipo", length = 100, unique = true)
    private String tipo;

}
