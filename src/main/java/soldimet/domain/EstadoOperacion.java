package soldimet.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A EstadoOperacion.
 */
@Entity
@Table(name = "estado_operacion")
public class EstadoOperacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "nombre_estado", nullable = false)
    private String nombreEstado;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public EstadoOperacion nombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
        return this;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EstadoOperacion estadoOperacion = (EstadoOperacion) o;
        if (estadoOperacion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), estadoOperacion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EstadoOperacion{" +
            "id=" + getId() +
            ", nombreEstado='" + getNombreEstado() + "'" +
            "}";
    }
}
