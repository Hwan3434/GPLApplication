package com.hwan3434.gplapplication.model

import org.json.JSONObject

abstract class Person : PersonInterface{

    var pKey = 0 // 고유키값
    var generator = 0; // 가평이씨 사직공파 n대손
    var name = "무명" // 이름
    var genader = false // 남 - true, 여 - false
    var spouse = 0

    fun createPerson(obj: JSONObject){

    }

}