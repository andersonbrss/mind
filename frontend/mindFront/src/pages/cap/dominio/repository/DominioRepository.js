import Repository from '@/service/Repository'
import { urlApi } from '@/global'

export default class Dominio extends Repository {
    /**
     * @param {*} options
     */
    constructor( options ) {
        super( options, `${ urlApi }/cap/dominios`)
    }
}