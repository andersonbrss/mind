<template>
    <div class="app-container app-theme-white">
        <page-title-comum
            :nomeFuncionalidade="header"
            :subTituloFuncionalidade="subHeader"
            :icon="icon"
            :idModal="idModal"
            v-on:configuraModal="recuperaNomeModal"
        />

        <div>
            <modal-component
                :idModal="idModal"
                :tituloModal="tituloModal"
                v-on:save="save"
                v-on:reset="limpar" >

                <b-form>
                    <div class="form-row">
                        <div class="col-md-12">
                            <div class="position-relative form-group">
                                <label>Nome</label>
                                <div class="control" >
                                    <b-form-input
                                        v-model="categoria.nmCategoria"
                                        name="nome"
                                        id="nmCategoria"
                                        placeholder="Digite o nome da categoria"
                                        type="text"

                                    /> 
                                </div>
                            </div>
                        </div>
                    </div>

                </b-form>

            </modal-component>

            <div>
                <tabela-component
                    :listaObjetos="list"
                    :camposFormulario="campos"
                    :v-on:load="load"
                    :v-on:delete="confirmModal"
                />
            </div>
        </div>
    </div>
</template>

<script>
import PageTitleComum from '../../../Layout/Components/PageTitleComum.vue';
import ModalComponent from '../../components/ModalComponent';
import TabelaComponent from '../../components/TabelaComponent';
import { confirmDialogObject, showError, showSuccess } from "@/global";

import Categoria from './../domain/Categoria';
import service from '../../comum/service/CategoriaService';

export default {
    name: 'Categoria',
    components: {
        PageTitleComum,
        ModalComponent,
        TabelaComponent
    },

    props: {
        table: String
    },

    data: function() {
        return {
            header: 'Categoria',
            subHeader: 'Lista de Categoria',
            icon: 'pe-7s-note2',
            idModal: 'cadastrar-categoria',
            tituloModal: 'Cadastro de categorias',
            categoria: new Categoria(),
            list: [],
            campos: [{
                key: 'nmCategoria',
                label: 'Nome',
                sortable: true
            }]
        }
    },

    methods: {
        limpar: function() {
            this.categoria = new Categoria();
        },

        recuperaNomeModal:function(){
            this.tituloModal = "Cadastro de Pauta";
        },

        getList: function() {
            service.getList()
                .then( res => {
                    this.list = res.data;
                })
                .catch( showError );
        },

        save: function() {
            if( this.categoria.id ) {
                service.update( this.categoria )
                    .then( () => {
                        showSuccess();
                    })
                    .catch( showError );
            } else {
                service.save( this.categoria )
                    .then( () => {
                        showSuccess();
                    }).catch( showError );
            }
        },

        delete: function( categoria ) {
            service.delete( categoria.id )
                .then( () => {
                    showSuccess();
                }).catch( showError );
        },

        load: function( categoria ) {
            this.$bvModal.show(this.idModal);
            this.tituloModal = 'Alteração Categoria';
            this.categoria = { ...categoria };
        },

        confirmModal: function( categoria ) {
            this.$bvModal
            .msgBoxConfirm (
                "Deseja realmente excluir o registro ? ", confirmDialogObject
            ).then(value => {
                if (value) this.delete(categoria);
            }).catch(showError);
        }
    },
    mounted: function() {
        this.getList();
    }
}
</script>

<style scoped>

</style>