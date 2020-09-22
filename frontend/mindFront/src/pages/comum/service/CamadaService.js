import CamadaDao from '../repository/CamadaRepository';

const dao = CamadaDao.build({});

export default {
    
    getList:() => {
        return dao.getList();
    },

    save:( camada ) => {
        return dao.save( camada );
    },

    update:( camada ) => {
        return dao.update( camada );
    },

    delete: ( id ) => {
        return dao.delete( id );
    }

}