<template>
    <div class="app-container app-theme-white">
        <page-title-comum :nomeFuncionalidade="header" :subTituloFuncionalidade="subHeader" :icon="icon" :idModal="idModal" v-on:configuraModal="recuperarNomeModal" />

        <div>
            <modal-component :idModal="idModal" :tituloModal="tituloModal" v-on:save="save" v-on:reset="limpar">
                <b-form>
                    <div class="col-md-12">
                        <div class="position-relative form-group">
                            <label for="nmLinguagem">Linguagem</label>
                            <div class="control">
                                <b-form-input v-model="linguagem.nmLinguagem" name="nmLinguagem" id="nmLinguagem" placeholder="Digite o nome da linguagem" type="text" />
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
import PageTitleComum from '../../../Layout/Components/PageTitleComum';
import ModalComponent from '../../components/ModalComponent';
import TabelaComponent from '../../components/TabelaComponent';
import { confirmDialogObject, showError, showSuccess } from '@/global';

import Linguagem from './../domain/Linguagem';
import service from '../service/LinguagemService';

export default {
    name: 'Linguagem',
    components: {
        PageTitleComum,
        ModalComponent,
        TabelaComponent
    },

    props: {

    },

    data: function() {
        return {
            header: 'Linguagem',
            subHeader: 'Lintagem de linguagem',
            icon: 'pe-7s-note2',
            idModal: 'cadastrar-linguagem',
            tituloModal: 'Cadastro de linguagem',
            linguagem: new Linguagem(),
            list: [],
            campos: [{
                key: 'nmLinguagem',
                label: 'Linguagem',
                sortable: true
            }]
        }
    },

    methods: {
        limpar: function() {
            this.linguagem = new Linguagem();
        },

        recuperarNomeModal: function() {
            this.tituloModal = 'Cadastro de linguagem';
        },

        getList: function() {
            service.getList().then( res => {
                this.list = res.data;
            }).catch( showError );
        },

        save: function() {
            if( this.linguagem.id ) {
                service.update( this.linguagem ).then( () => {
                    showSuccess();
                }).catch( showError );
            } else {
                service.save( this.linguagem ).then( () => {
                    showSuccess();
                }).catch( showError );
            }
        },

        delete: function( linguagem ) {
            service.delete( linguagem.id ).then( () => {
                showSuccess();
            }).catch( showError );
        },

        load: function( linguagem ) {
            this.$bvModal.show( this.idModal );
            this.tituloModal = 'Alterar linguagem';
            this.linguagem = { ...linguagem };
        },

        confirmModal: function( linguagem ) {
            this.$bvModal.msgBoxConfirm(
                "Deseja realmente excluir o registro ?", confirmDialogObject
            ).then( value => {
                if( value ) this.delete( linguagem );
            }).catch( showError );
        }
    },

    mounted: function() {
        this.getList();
    }
}
</script>