package soldimet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Presupuesto.
 */
@Entity
@Table(name = "presupuesto")
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5)
    @Column(name = "descripcion_descuento")
    private String descripcionDescuento;

    @DecimalMin(value = "0")
    @Column(name = "descuento")
    private Float descuento;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_aceptado")
    private LocalDate fechaAceptado;

    @Column(name = "fecha_entregado")
    private LocalDate fechaEntregado;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "importe_total", nullable = false)
    private Float importeTotal;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(optional = false)
    @NotNull
    private Cliente cliente;

    @ManyToOne(optional = false)
    @NotNull
    private EstadoPresupuesto estadoPresupuesto;

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name= "presupuesto")
    private Set<DetallePresupuesto> detallePresupuestos = new HashSet<DetallePresupuesto>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionDescuento() {
        return descripcionDescuento;
    }

    public Presupuesto descripcionDescuento(String descripcionDescuento) {
        this.descripcionDescuento = descripcionDescuento;
        return this;
    }

    public void setDescripcionDescuento(String descripcionDescuento) {
        this.descripcionDescuento = descripcionDescuento;
    }

    public Float getDescuento() {
        return descuento;
    }

    public Presupuesto descuento(Float descuento) {
        this.descuento = descuento;
        return this;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Presupuesto fechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaAceptado() {
        return fechaAceptado;
    }

    public Presupuesto fechaAceptado(LocalDate fechaAceptado) {
        this.fechaAceptado = fechaAceptado;
        return this;
    }

    public void setFechaAceptado(LocalDate fechaAceptado) {
        this.fechaAceptado = fechaAceptado;
    }

    public LocalDate getFechaEntregado() {
        return fechaEntregado;
    }

    public Presupuesto fechaEntregado(LocalDate fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
        return this;
    }

    public void setFechaEntregado(LocalDate fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public Float getImporteTotal() {
        return importeTotal;
    }

    public Presupuesto importeTotal(Float importeTotal) {
        this.importeTotal = importeTotal;
        return this;
    }

    public void setImporteTotal(Float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Presupuesto observaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Presupuesto cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoPresupuesto getEstadoPresupuesto() {
        return estadoPresupuesto;
    }

    public Presupuesto estadoPresupuesto(EstadoPresupuesto estadoPresupuesto) {
        this.estadoPresupuesto = estadoPresupuesto;
        return this;
    }

    public void setEstadoPresupuesto(EstadoPresupuesto estadoPresupuesto) {
        this.estadoPresupuesto = estadoPresupuesto;
    }

    public Set<DetallePresupuesto> getDetallePresupuestos() {
        return detallePresupuestos;
    }

    public Presupuesto detallePresupuestos(Set<DetallePresupuesto> detallePresupuestos) {
        this.detallePresupuestos = detallePresupuestos;
        return this;
    }

    public Presupuesto addDetallePresupuesto(DetallePresupuesto detallePresupuesto) {
        this.detallePresupuestos.add(detallePresupuesto);
        return this;
    }

    public Presupuesto removeDetallePresupuesto(DetallePresupuesto detallePresupuesto) {
        this.detallePresupuestos.remove(detallePresupuesto);
        return this;
    }

    public void setDetallePresupuestos(Set<DetallePresupuesto> detallePresupuestos) {
        this.detallePresupuestos = detallePresupuestos;
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
        Presupuesto presupuesto = (Presupuesto) o;
        if (presupuesto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), presupuesto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
            "id=" + getId() +
            ", descripcionDescuento='" + getDescripcionDescuento() + "'" +
            ", descuento=" + getDescuento() +
            ", fechaCreacion='" + getFechaCreacion() + "'" +
            ", fechaAceptado='" + getFechaAceptado() + "'" +
            ", fechaEntregado='" + getFechaEntregado() + "'" +
            ", importeTotal=" + getImporteTotal() +
            ", observaciones='" + getObservaciones() + "'" +
            "}";
    }
}
