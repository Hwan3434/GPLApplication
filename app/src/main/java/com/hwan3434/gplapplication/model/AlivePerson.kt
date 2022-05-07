package com.hwan3434.gplapplication.model

import org.json.JSONObject


/**
 * 아직 산사람
 */
class AlivePerson(personJSON: JSONObject) : Person() {

    var location = "" // 사는곳

    init {
        super.createPerson(personJSON)
    }

    override fun getPersonName(): String {
        return this.name
    }
}