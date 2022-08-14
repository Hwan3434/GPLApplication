package com.hwan3434.gplapplication.data.database

import androidx.room.TypeConverter
import com.hwan3434.gplapplication.data.enum.GpEnum

class RoomDBConvert {


    @TypeConverter
    fun fromTome(value: GpEnum.TombType) : String {
        return if(value == GpEnum.TombType.TOMB) "Tomb" else "Fire"
    }

    @TypeConverter
    fun toTomb(value : String) : GpEnum.TombType{
        return if(value == "Tomb") GpEnum.TombType.TOMB else GpEnum.TombType.FIRE
    }



}