<template>
    <div class="app-container app-theme-white">
        <page-title-comum :nomeFuncionalidade="header" :subTituloFuncionalidade="subHeader" :icon="icon" :idModal="idModal" v-on:configuraModal="recuperaNomeModal" />

        <div>
            <modal-component :idModal="idModal" :tituloModal="tituloModal" v-on:save="save" v-on:reset="limpar" >
                <b-form>
                    <div class="form-row">
                        <div class="col-md-12">
                            <div class="position-relative form-group">
                                <label for="nmTipo"> Nome</label>
                                <div class="control">
                                    <b-form-input v-model="tipo.nmTipo" name="nmTipo" id="nmTipo" placeholder="Digite o tipo" type="text" />
                                </div>
                            </div>
                        </div>
                    </div>
                </b-form>
            </modal-component>

            <div>
                <tabela-component :listaObjetos="list" :camposFormulario="campos" :v-on:load="load" :v-on:delete="confirmModal" />
            </div>

        </div>

    </div>
</template>

<script>
import PageTitleComum from '../../../Layout/Components/PageTitleComum.vue';
import ModalComponent from '../../components/ModalComponent';
import TabelaComponent from '../../components/TabelaComponent';
import { confirmDialogObject, showError, showSuccess } from "@/global";

import Tipo from './../domain/Tipo';
import service from '../service/TipoService';

export default {
    name: 'Tipo',
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
            header: 'Tipo',
            subHeader: 'Lista de tipos',
            icon: 'pe-7s-note2',
            idModal: 'cadastrar-tipo',
            tituloModal: 'Cadastro de tipo',
            tipo: new Tipo(),
            list: [],
            campos: [{
                key: 'nmTipo',
                label: 'Tipo',
                sortable: true
            }]
        }
    },

    methods: {
        limpar: function() {
            this.tipo = new Tipo();
        },

        recuperaNomeModal: function() {
            this.tituloModal = 'Cadastro de tipo';
        },

        getList: function() {
            service.getList()
                .then( res => {
                    this.list = res.data;
                }).catch( showError );
        },

        save: function() {
            if( this.tipo.id ) {
                service.update( this.tipo ).then( () => {
                    showSuccess();
                }).catch( showError );
            } else {
                service.save( this.tipo ).then( () => {
                    showSuccess();
                }).catch( showError );
            }
        },

        delete: function( tipo ) {
            service.delete( tipo.id ).then( () => {
                showSuccess();
            }).catch( showError );
        },

        load: function( tipo ) {
            this.$bvModal.show( this.idModal );
            this.tituloModal = 'Alteração tipo';
            this.tipo = { ...tipo };
        },

        confirmModal: function( tipo ) {
            this.$bvModal.msgBoxConfirm(
                "Deseja realmente excluir o registro?", confirmDialogObject
            ).then( value => {
                if( value ) this.delete( tipo );
            }).catch( showError );
        }
    },

    mounted: function() {
        this.getList();
    }
    
}
</script>