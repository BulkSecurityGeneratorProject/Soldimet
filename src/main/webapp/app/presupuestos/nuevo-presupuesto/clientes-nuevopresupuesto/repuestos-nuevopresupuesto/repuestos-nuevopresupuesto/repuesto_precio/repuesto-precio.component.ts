import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { TipoRepuesto } from 'app/shared/model/tipo-repuesto.model';
import { CobranzaRepuesto } from 'app/shared/model/cobranza-repuesto.model';

@Component({
    selector: 'jhi-repuesto-precio',
    templateUrl: './repuesto-precio.component.html',
    styles: []
})
export class RepuestoPrecioComponent implements OnInit {
    @Input() repuesto: TipoRepuesto;
    seleccionado = false;
    precio = 0;
    precioAnterior = 0;
    @Output() eventoCambioValor = new EventEmitter<number>();

    constructor() {}

    ngOnInit() {}

    marcado(): Boolean {
        return this.seleccionado;
    }

    getArticuloAcobrar(): CobranzaRepuesto {
        const nuevaCobranzaRepuesto = new CobranzaRepuesto();
        nuevaCobranzaRepuesto.valor = this.precio;
        nuevaCobranzaRepuesto.tipoRepuesto = this.repuesto;
        return nuevaCobranzaRepuesto;
    }

    cambioValor() {
        this.eventoCambioValor.emit();
    }

    getPrecio() {
        if (this.seleccionado) {
            return this.precio;
        } else {
            return 0;
        }
    }
}
