<template>
    <div class="app-container app-theme-white">
        <page-title-comum :nomeFuncionalidade="header" :subTituloFuncionalidade="subHeader" :icon="icon" :idModal="idModal" v-on:configuraModal="recuperaNomeModal" />
    
        <div>
            <modal-component :idModal="idModal" :tituloModal="tituloModal" v-on:save="save" v-on:reset="limpar" >
                <b-form>
                    <div class="form-row">
                        <div class="col-md-12">
                            <div class="position-relative form-group">
                                <label for="nmCamada"> Nome</label>
                                <div class="control">
                                    <b-form-input  v-model="camada.nmCamada" name="nmCamada" id="nmCamada" placeholder="Digite a camada" type="text" />
                                </div>
                            </div>
                        </div>
                    </div>
                </b-form>
            </modal-component>

            <div>
                <tabela-component :listaObjetos="list" :camposFormulario="campos" :v-on:load="load" v-on:delete="confirmModal" />
            </div>

        </div>
    </div>
</template>

<script>
import PageTitleComum from '../../../Layout/Components/PageTitleComum.vue';
import ModalComponent from '../../components/ModalComponent';
import TabelaComponent from '../../components/TabelaComponent';
import { confirmDialogObject, showError, showSuccess } from "@/global";

import Camada from './../domain/Camada';
import service from '../service/CamadaService';

export default {
    name: 'Camada',
    components: {
        PageTitleComum,
        ModalComponent,
        TabelaComponent
    },

    props: {
        // table: String
    },

    data: function() {
        return {
            header: 'Camada',
            subHeader: 'Lista de camadas',
            icon: 'pe-7s-note2',
            idModal: 'cadastrar-camada',
            tituloModal: 'Cadastro de camada',
            camada : new Camada(),
            list: [],
            campos: [{
                key: 'nmCamada',
                label: 'Camada',
                sortable: true
            }]
        }
    },

    methods: {
        limpar: function() {
            this.camada = new Camada();
        },

        recuperaNomeModal: function() {
            this.tituloModal = 'Cadastro de camada';
        },

        getList: function() {
            service.getList()
                .then( res => {
                    this.list = res.data;
                }).catch( showError );
        },

        save: function() {
            if( this.camada.id ) {
                service.update( this.camada )
                    .then( () => {
                        showSuccess();
                    }).catch( showError );
            } else {
                service.save( this.camada )
                    .then( () => {
                        showSuccess();
                    }).catch( showError );
            }
        },

        delete: function( camada ) {
            service.delete( camada.id )
                .then( () => {
                    showSuccess();
                }).catch( showError );
        },

        load: function( camada ) {
            this.$bvModal.show( this.idModal );
            this.tituloModal = 'Alteração camada';
            this.camada = { ...camada };
        },

        confirmModal: function( camada ) {
            this.$bvModal.msgBoxConfirm(
                "Deseja realmente excluir o registro ?", confirmDialogObject 
            ).then( value => {
                if( value ) this.delete( camada );
            }).catch( showError );
        }
    },
    mounted: function() {
        this.getList();
    }
}
</script>