import LinguagemDao from '../repository/LinguagemRepository';

const dao = LinguagemDao.build({});

export default {

    getList:() => {
        return dao.getList();
    },

    save:( linguagem ) => {
        return dao.save( linguagem );
    },

    update:( linguagem ) => {
        return dao.update( linguagem );
    },

    delete:( id ) => {
        return dao.delete( id );
    }
}