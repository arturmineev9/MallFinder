package com.example.mallfinder.data

object MallRepository {
    private val categoriesRepository = CategoryRepository
    private val shopsRepository = ShopRepository
    val malls = mutableMapOf<String, Mall>()

    init {
        malls["ТРК «Парк Хаус»"] = Mall(name ="ТРК «Парк Хаус»",
            address = "проспект Хусаина Ямашева, 46/33",
            description = "В двухуровневом ТРК расположено огромное количество топовых магазинов, в том числе «Ашан». Семьи с детьми могут посетить развлекательный парк «Остров сокровищ», провести время в кинотеатре или семейном кафе. " +
                "Любители активного отдыха могут посетить скалодром и батутный парк. На просторном фуд-корте доступны заведения с кухнями различных стран мира. " +
                "Даже о людях с ограниченными возможностями в этом ТЦ позаботились, оборудовав специальные туалеты.\n",
            url = "https://img.tourister.ru/files/2/1/2/0/8/9/0/7/original.jpg",
            work_hours = "10:00 - 22:00",
            coordinates = Pair(55.82917344093007, 49.1168064821896),
            shop_list = listOf(
                shopsRepository.getShopByName("BEFREE"),
                shopsRepository.getShopByName("DNS"),
                shopsRepository.getShopByName("М.ВИДЕО"),
                shopsRepository.getShopByName("АШАН"),
                shopsRepository.getShopByName("КОРД ОПТИКА"),
                shopsRepository.getShopByName("Л’ЭТУАЛЬ"),
                shopsRepository.getShopByName("NAM"),
                shopsRepository.getShopByName("SALAMANDER"),
                shopsRepository.getShopByName("МОНРО"),
                shopsRepository.getShopByName("ECRU"),
                shopsRepository.getShopByName("GLORIA JEANS"),
                shopsRepository.getShopByName("Л’ЭТУАЛЬ"),
                shopsRepository.getShopByName("GLЭМ"),
                shopsRepository.getShopByName("O’STIN"),
                shopsRepository.getShopByName("ТВОЕ")

                ),
            categories = listOf(
                categoriesRepository.getCategoryNameById(1),
                categoriesRepository.getCategoryNameById(2),
                categoriesRepository.getCategoryNameById(3),
                categoriesRepository.getCategoryNameById(4),
                categoriesRepository.getCategoryNameById(5),
                )
        )
        malls["ТРК «Тандем»"] = Mall(name = "ТРК «Тандем»",
            address = "проспект Ибрагимова, 56",
            description = "Автомобилисты оценят просторную парковку комплекса на 1,5 тыс машиномест. Огромное количество бутиков, сетевых магазинов от «Спортмастера» до «Эльдорадо» позволят найти все необходимое. " +
                    "Творческим людям придется по вкусу гипермаркет «Леонардо», часто проводящий мастер-классы. Свободное время можно провести в бильярдной, боулинг-центре, одном из девяти залов кинотеатра. Огромный выбор ресторанов и кафе приятно удивят разнообразием. " +
                    "Семейный парк развлечений поможет отлично провести время всей семьей.\n",
            url = "https://sprb.by/uploads/posts/2016-09/1475085910_0v4a3282.jpg",
            work_hours = "10:00 - 22:00",
            coordinates = Pair(55.821391742113086, 49.09335574987023),
            shop_list = listOf(
                shopsRepository.getShopByName("ЭЛЬДОРАДО"),
                shopsRepository.getShopByName("ПЕРЕКРЕСТОК"),
                shopsRepository.getShopByName("Л’ЭТУАЛЬ"),
                shopsRepository.getShopByName("ECCO"),
                shopsRepository.getShopByName("SALAMANDER"),
                shopsRepository.getShopByName("BEFREE"),
                shopsRepository.getShopByName("GLORIA JEANS"),
                shopsRepository.getShopByName("GLЭМ"),
                shopsRepository.getShopByName("LOVE REPUBLIC"),
                shopsRepository.getShopByName("O’STIN"),
                shopsRepository.getShopByName("ZARINA"),
                shopsRepository.getShopByName("ТВОЕ")
                ),
            categories = listOf(
                categoriesRepository.getCategoryNameById(1),
                categoriesRepository.getCategoryNameById(2),
                categoriesRepository.getCategoryNameById(3),
                categoriesRepository.getCategoryNameById(4),
                categoriesRepository.getCategoryNameById(5),
            )
        )
        malls["ТРЦ «МЕГА»"] =  Mall(name = "ТРЦ «МЕГА»",
            address = "Проспект Победы, 141",
            description = "В этом ТРЦ можно найти все: от мебели до сувениров и продуктов питания." +
                    " Огромный фуд-корт, более двух десятков кафе и ресторанов, детские площадки," +
                    " ледовый каток помогут отлично провести время людям любого возраста." +
                    " В комплексе часто проходят мастер-классы, праздники и фестивали. Наличие" +
                    " бесплатного трансфера, оснащения для людей с ограниченными возможностями," +
                    " комнаты для матери и ребенка, комнат отдыха создают ощущения заботы о комфорте" +
                    " посетителей.",
            url = "https://даария.рф/pic/others/40839591621858742.jpg",
            work_hours = "10:00 - 22:00",
            coordinates = Pair(55.78093161015182, 49.212217597529666),
            shop_list = listOf(
                shopsRepository.getShopByName("DNS"),
                shopsRepository.getShopByName("POLARIS"),
                shopsRepository.getShopByName("ECCO"),
                shopsRepository.getShopByName("NAM"),
                shopsRepository.getShopByName("SALAMANDER"),
                shopsRepository.getShopByName("BEFREE"),
                shopsRepository.getShopByName("ECRU"),
                shopsRepository.getShopByName("GLЭМ"),
                shopsRepository.getShopByName("LOVE REPUBLIC"),
                shopsRepository.getShopByName("MANGO"),
                shopsRepository.getShopByName("O’STIN"),
                shopsRepository.getShopByName("ZARINA"),
                shopsRepository.getShopByName("ТВОЕ"),
                ),
            categories = listOf(
                categoriesRepository.getCategoryNameById(1),
                categoriesRepository.getCategoryNameById(2),
                categoriesRepository.getCategoryNameById(3),
            )
        )

        malls["ТРЦ «KazanMall»"] = Mall(name = "ТРЦ «KazanMall»",
            address = "улица Павлюхина, 91",
            description = "Посетителей ожидают три торговых уровня, двухэтажная парковка на 1,5 тыс " +
                    "машиномест. Третий этаж ТРЦ отведен под рестораны, кафе, кинотеатр с несколькими" +
                    " залами, развлекательный центр для детей. Часть уровня расположена под открытым" +
                    " небом, что позволяет сделать отличные фото и насладиться превосходными видами." +
                    " Огромное количество крупных магазинов и удобное расположение комплекса в самом" +
                    " центре города оценят представители любых возрастов.",
            url = "https://arenda-trk.ru/wp-content/uploads/2020/11/kazanmall-kzn.jpg",
            work_hours = "10:00 - 22:00",
            coordinates = Pair(55.76781733445818, 49.14699901102196),
            shop_list = listOf(
                shopsRepository.getShopByName("DNS"),
                shopsRepository.getShopByName("POLARIS"),
                shopsRepository.getShopByName("ЛЕНТА"),
                shopsRepository.getShopByName("ЗОЛОТОЕ ЯБЛОКО"),
                shopsRepository.getShopByName("EKONIKA"),
                shopsRepository.getShopByName("BEFREE"),
                shopsRepository.getShopByName("GLORIA JEANS"),
                shopsRepository.getShopByName("LOVE REPUBLIC"),
                shopsRepository.getShopByName("O’STIN"),
                shopsRepository.getShopByName("ТВОЕ")
                ),
            categories = listOf(
                categoriesRepository.getCategoryNameById(1),
                categoriesRepository.getCategoryNameById(2),
                categoriesRepository.getCategoryNameById(3),
                categoriesRepository.getCategoryNameById(4),
                categoriesRepository.getCategoryNameById(5),
            )
        )
    }

    fun getMallById(mallName: String): Mall? {
        return malls[mallName]
    }

}
