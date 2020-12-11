package com.example.semesteroppgave

object houseObject1 : HouseConstructor(
        "Lambertseterveien 12",
        HouseType.LEILIGHET,
        2750000,
        "Oslo",
        81
)

object houseObject2 : HouseConstructor(
        "Lambertseterveien 45",
        HouseType.REKKEHUS,
        1647000,
        "Oslo",
        45
)

object houseObject3 : HouseConstructor(
        "Mikrobølgen 4",
        HouseType.REKKEHUS,
        4285800,
        "Oslo",
        97
)

object houseObject4 : HouseConstructor(
        "Nordstjernegrenda 5",
        HouseType.LEILIGHET,
        8755000,
        "Tromsø",
        67
)

object houseObject5 : HouseConstructor(
        "Hammerborgen 5",
        HouseType.ENEBOLIG,
        6750000,
        "Tønsberg",
        210
)

val houseObjectsList = mutableListOf<HouseConstructor>(
        houseObject1,
        houseObject2,
        houseObject3,
        houseObject4,
        houseObject5
)