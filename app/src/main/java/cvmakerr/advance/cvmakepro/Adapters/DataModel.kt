package cvmakerr.advance.cvmakepro.Adapters

/**
 * Created by anupamchugh on 09/02/16.
 */
class DataModel {
    constructor() {}

    var number: String? = null
    var id_number = 0

    constructor(number: String?, id_number: Int) {
        this.id_number = id_number
        this.number = number
    }
}