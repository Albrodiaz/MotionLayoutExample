package com.example.motionlayoutexample.repository

import com.example.motionlayoutexample.domain.Car

class CarProvider {
    private val carList = mutableListOf(
        Car(
            1,
            "Toyota",
            "CHR",
            140,
            1800,
            "https://cdn-images.motor.es/image/m/1280w/fotos-noticias/2020/10/precio-toyota-c-hr-2021-202072328-1603986446_1.jpg"
        ),
        Car(
            2,
            "Citroen",
            "C4",
            120,
            1600,
            "https://static.motor.es//fotos-noticias/2016/10/min652x435/precio-citroen-c4-2017-201630946_1.jpg"
        ),
        Car(
            3,
            "Renault",
            "Megane",
            90,
            1900,
            "https://fotografias.lasexta.com/clipping/cmsimages02/2022/04/03/1C7A60B2-814B-4637-9BCC-12EF00995CB8/nueva-gama-renault-megane-2022-venta_97.jpg?crop=1422,800,x40,y0&width=1600&height=900&optimize=high&format=webply"
        ),
        Car(
            4,
            "Citroen",
            "C5 Aircross",
            180,
            2400,
            "https://d1eip2zddc2vdv.cloudfront.net/dphotos/750x400/22879563-1644504857.jpeg"
        ),
        Car(
            5,
            "Volkswagen",
            "Golf",
            140,
            2000,
            "https://static.motor.es/fotos-jato/volkswagen/uploads/volkswagen-golf-gte_mid60182c4c5968d.jpg"
        ),
        Car(
            6,
            "Dacia",
            "Sandero",
            75,
            1400,
            "https://cdn-images.motor.es/image/m/694w/fotos-noticias/2022/10/dacia-sandero-2028-adelanto-202290531-1666005535_1.jpg"
        ),
        Car(
            7,
            "Seat",
            "Ibiza",
            90,
            1600,
            "https://cdn-images.motor.es/image/m/694w/fotos-noticias/2022/06/precio-seat-ibiza-xl-202287741-1655319382_1.jpg"
        ),
    )

    fun getCars() = carList

    fun deleteCar(car: Car) {
        carList.remove(car)
    }
}