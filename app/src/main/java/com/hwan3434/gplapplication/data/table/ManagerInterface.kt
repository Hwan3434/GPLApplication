package com.hwan3434.gplapplication.data.table

import org.json.JSONObject

interface ManagerInterface {

    fun getFamilyPerson(familyKey:String): List<String>
}