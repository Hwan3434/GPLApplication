package com.hwan3434.gplapplication.model.factory

import com.hwan3434.gplapplication.data.DataInterface
import com.hwan3434.gplapplication.model.AlivePerson
import com.hwan3434.gplapplication.model.DeadPerson
import com.hwan3434.gplapplication.model.Person
import org.json.JSONObject

object PersonFactory {


    lateinit var dataInterface: DataInterface


    // 주입 해주는거 잘 해야합니데이
    fun CreateFactory(dataInterface: DataInterface){
        this.dataInterface = dataInterface
    }

    fun <T: Person> getFamilyPerson(familyKey:String) : List<Person> {
        var resultPerson: ArrayList<Person> = arrayListOf()
        var familyJson = dataInterface.getFamilyPerson(familyKey)
        for (jsonObj:String  in familyJson){
            var personJSON = JSONObject(jsonObj)
            val alive: Boolean = personJSON["avlie"] == "1"
            if(alive){
                resultPerson.add(AlivePerson(personJSON))
            }else {
                resultPerson.add(DeadPerson(personJSON))
            }
        }
        return resultPerson
    }

}