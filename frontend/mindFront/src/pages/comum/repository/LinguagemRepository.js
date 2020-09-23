import Repository from '../../../service/Repository';
import { urlApi } from '@/global';

export default class LinguagemDao extends Repository {
    /**
     * @param {*} options
     */
    constructor( options ) {
        super( options, `${ urlApi }/comum/linguagens`);
    }
}