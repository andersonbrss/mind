import Repository from '../../../service/Repository';
import { urlApi } from '@/global';

export default class CamadaDao extends Repository {

    /**
     * @param {*} options
     */
    constructor( options ) {
        super( options, `${ urlApi }/comum/camadas`)
    }

}