<template>
  <div v-if="!listaObjetos.length == 0">
    <div class="main-card mb-3 card">
      <div class="card-body">
        <b-table :items="listaObjetos" :fields="camposFormulario" striped hover responsive="sm" id="tabela" :per-page="perPage" :current-page="currentPage">
          <template v-slot:cell(actions)="data">
            <b-button variant="warning" @click="$emit('load', data.item)" class="mr-2">
              <font-awesome-icon icon="pencil-alt" />
            </b-button>
            <b-button variant="danger" @click="$emit('delete', data.item)">
              <font-awesome-icon icon="trash" />
            </b-button>
          </template>
        </b-table>
      </div>
      <div>
        <b-pagination align="right" :total-rows="listaObjetos.length" v-model="currentPage" :per-page="10"
        />
      </div>
      <div class="divider"></div>
      <br />
    </div>
  </div>
</template>

<script>
import { library } from "@fortawesome/fontawesome-svg-core";
import { faPencilAlt, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faPencilAlt, faTrash);

export default {
  name: "TabelaComponent",
  components: {
    "font-awesome-icon": FontAwesomeIcon
  },
  props: {
    listaObjetos: Array,
    camposFormulario: Array
  },
  data: function() {
    return {
      perPage: 10,
      currentPage: 1
    };
  },
  computed: {
    rows() {
      return this.listaObjetos.length;
    }
  }
};
</script>
