import CategoriaDao from '../repository/CategoriaRepository';

const dao = CategoriaDao.build({});

export default {

    getList:() => {
        return dao.getList();
    },
    
    save:( categoria ) => {
        return dao.save( categoria );
    },

    update:( categoria ) => {
        return dao.update( categoria );
    },

    delete: ( id ) => {
        return dao.delete( id );
    }
}