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
 * A PedidoRepuesto.
 */
@Entity
@Table(name = "pedido_repuesto")
public class PedidoRepuesto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "fecha_recibo")
    private LocalDate fechaRecibo;

    @ManyToOne(optional = false)
    @NotNull
    private EstadoPedidoRepuesto estadoPedidoRepuesto;

    @OneToMany
    @JoinColumn(name= "pedidoRepuesto")
    @JsonIgnore
    private Set<DetallePedido> detallePedidos = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    private Presupuesto presupuesto;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public PedidoRepuesto fechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public PedidoRepuesto fechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
        return this;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaRecibo() {
        return fechaRecibo;
    }

    public PedidoRepuesto fechaRecibo(LocalDate fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
        return this;
    }

    public void setFechaRecibo(LocalDate fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
    }

    public EstadoPedidoRepuesto getEstadoPedidoRepuesto() {
        return estadoPedidoRepuesto;
    }

    public PedidoRepuesto estadoPedidoRepuesto(EstadoPedidoRepuesto estadoPedidoRepuesto) {
        this.estadoPedidoRepuesto = estadoPedidoRepuesto;
        return this;
    }

    public void setEstadoPedidoRepuesto(EstadoPedidoRepuesto estadoPedidoRepuesto) {
        this.estadoPedidoRepuesto = estadoPedidoRepuesto;
    }

    public Set<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public PedidoRepuesto detallePedidos(Set<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
        return this;
    }

    public PedidoRepuesto addDetallePedido(DetallePedido detallePedido) {
        this.detallePedidos.add(detallePedido);
        return this;
    }

    public PedidoRepuesto removeDetallePedido(DetallePedido detallePedido) {
        this.detallePedidos.remove(detallePedido);
        return this;
    }

    public void setDetallePedidos(Set<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public PedidoRepuesto presupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
        return this;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
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
        PedidoRepuesto pedidoRepuesto = (PedidoRepuesto) o;
        if (pedidoRepuesto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), pedidoRepuesto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PedidoRepuesto{" +
            "id=" + getId() +
            ", fechaCreacion='" + getFechaCreacion() + "'" +
            ", fechaPedido='" + getFechaPedido() + "'" +
            ", fechaRecibo='" + getFechaRecibo() + "'" +
            "}";
    }
}
