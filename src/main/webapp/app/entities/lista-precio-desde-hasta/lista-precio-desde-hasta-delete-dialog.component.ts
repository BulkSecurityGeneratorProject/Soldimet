import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IListaPrecioDesdeHasta } from 'app/shared/model/lista-precio-desde-hasta.model';
import { ListaPrecioDesdeHastaService } from './lista-precio-desde-hasta.service';

@Component({
    selector: 'jhi-lista-precio-desde-hasta-delete-dialog',
    templateUrl: './lista-precio-desde-hasta-delete-dialog.component.html'
})
export class ListaPrecioDesdeHastaDeleteDialogComponent {
    listaPrecioDesdeHasta: IListaPrecioDesdeHasta;

    constructor(
        private listaPrecioDesdeHastaService: ListaPrecioDesdeHastaService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.listaPrecioDesdeHastaService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'listaPrecioDesdeHastaListModification',
                content: 'Deleted an listaPrecioDesdeHasta'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-lista-precio-desde-hasta-delete-popup',
    template: ''
})
export class ListaPrecioDesdeHastaDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ listaPrecioDesdeHasta }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(ListaPrecioDesdeHastaDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.listaPrecioDesdeHasta = listaPrecioDesdeHasta;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
