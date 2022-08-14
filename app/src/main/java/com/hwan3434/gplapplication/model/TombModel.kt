package com.hwan3434.gplapplication.model

import com.hwan3434.gplapplication.data.enum.GpEnum


// 묘지
class TombModel {

    var TombType = GpEnum.TombType.TOMB
    var location_Loc = 0.0
    var location_Lac = 0.0

    var owner : List<Person> = listOf() // 합장했으면 2명 이상이다.


}