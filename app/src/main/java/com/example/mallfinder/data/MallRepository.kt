package com.example.mallfinder.data

object MallRepository {
    private val categoriesRepository = CategoryRepository()
    private val shopsRepository = ShopRepository
    val malls = mutableMapOf<String, Mall>()

    init {
        malls["ТРК «Парк Хаус"] = Mall(name ="ТРК «Парк Хаус»",
            address = "проспект Хусаина Ямашева, 46/33",
            description = "В двухуровневом ТРК расположено огромное количество топовых магазинов, в том числе «Ашан». Семьи с детьми могут посетить развлекательный парк «Остров сокровищ», провести время в кинотеатре или семейном кафе. " +
                "Любители активного отдыха могут посетить скалодром и батутный парк. На просторном фуд-корте доступны заведения с кухнями различных стран мира. " +
                "Даже о людях с ограниченными возможностями в этом ТЦ позаботились, оборудовав специальные туалеты.\n",
            url = "https://sun9-50.userapi.com/impg/gHBstRKoraNt1WwQWZfwRq0tzAAzlDfR6FU4aw/p493ex-KAYM.jpg?size=1280x854&quality=96&sign=04f09b4da389c7862dbf2f3d427df3c7&c_uniq_tag=eUjAqQazzfhcD08zrC1vVYgHucRjqt_iFxLOl77Konc&type=album\n",
            work_hours = "10:00 - 22:00",
            coordinates = "",
            shop_list = listOf(
                shopsRepository.getShopByName("BEFREE"),
                shopsRepository.getShopByName("DNS")
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
            coordinates = "",
            shop_list = listOf(
                shopsRepository.getShopByName("ECCO"),

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
    fun addMall(mall: Mall) {
        malls[mall.name] = mall
    }

    fun removeMall(mallName: String) {
        malls.remove(mallName)
    }

    fun getMallById(mallName: String): Mall? {
        return malls[mallName]
    }

    fun getAllMalls(): Map<String, Mall> {
        return malls
    }

}
