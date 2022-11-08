package com.hwan3434.gplapplication.domain.db.base

import androidx.room.TypeConverter
import com.google.firebase.firestore.GeoPoint
import com.google.gson.Gson


class RoomDBConvert {

    @TypeConverter
    fun stringToGeoPoint(data: String?): GeoPoint? {
        return Gson().fromJson(data, GeoPoint::class.java)
    }

    @TypeConverter
    fun geoPointToString(geoPoint: GeoPoint?): String? {
        return Gson().toJson(geoPoint)
    }


}