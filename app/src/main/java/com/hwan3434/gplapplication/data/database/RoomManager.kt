package com.hwan3434.gplapplication.data.database

import com.hwan3434.gplapplication.data.table.ManagerInterface

/**
 * Room 을 이용한 데이터 베이스 매니저
 */
class RoomManager: ManagerInterface {
    override fun getFamilyPerson(familyKey: String): List<String> {
        TODO("Not yet implemented")
    }
}