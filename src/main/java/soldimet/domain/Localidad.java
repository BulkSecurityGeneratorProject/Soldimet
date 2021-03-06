package soldimet.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Localidad.
 */
@Entity
@Table(name = "localidad")
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "nombre_localidad", nullable = false)
    private String nombreLocalidad;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public Localidad nombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
        return this;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
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
        Localidad localidad = (Localidad) o;
        if (localidad.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), localidad.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Localidad{" +
            "id=" + getId() +
            ", nombreLocalidad='" + getNombreLocalidad() + "'" +
            "}";
    }
}
