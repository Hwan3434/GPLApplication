package com.hwan3434.gplapplication.model

import org.json.JSONObject

/**
 * 죽은사람
 */
class DeadPerson(personJSON: JSONObject) : Person() {


    lateinit var tomb : TombModel // 없으면 죽은사람이 아니다.
    var yearMonth = "yyyyMMdd" // 죽은날짜

    init {
        super.createPerson(personJSON)
    }


    override fun getPersonName(): String {
        return name
    }


}