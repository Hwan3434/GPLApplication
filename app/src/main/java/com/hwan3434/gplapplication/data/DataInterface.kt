package com.hwan3434.gplapplication.data

interface DataInterface {
    fun getFamilyPerson(familyKey: String) : List<String>
}