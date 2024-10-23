package apicalendario.apicalendario.dominio;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "calendario") 
public class Calendario {

    @Id
    @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_calendario")
    @GenericGenerator(name = "secuencia_calendario", strategy = "increment")
    private long id;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo tipo;

    @Column(name = "descripcion")
    private String descripcion;
}