import TipoDao from '../repository/TipoRepository';

const dao = TipoDao.build({});

export default {

    getList:() => {
        return dao.getList();
    },

    save:( tipo ) => {
        return dao.save( tipo );
    },

    update: ( tipo ) => {
        return dao.update( tipo );
    },

    delete: ( id ) => {
        return dao.delete( id );
    }
}