package com.example.mallfinder.data


object ShopRepository {
    private val categoriesRepository = CategoryRepository()
    val shops = mutableMapOf<String, Shop>()
    init {
        shops["BEFREE"] = Shop(name ="BEFREE",
            category =  categoriesRepository.getCategoryNameById(1),
            description = "Befree — бренд для всех, кто любит молодежную моду, независимо от возраста. Свобода самовыражения, инклюзивность, красота и уникальность каждого — вот ценности, которые мы продвигаем.(новый абзац)Магазины Befree — это пространства в стиле минималистичного fusion с комфортной зоной отдыха и мягким светом в примерочных. У нас есть мужской и женский отделы, обувь, одежда для дома и спорта, белье и аксессуары. " +
                    "Отдельное направление — коллекции Befree Co:Create, которые мы создаем вместе с художниками, дизайнерами и инфлюэнсерами. Присоединяйтесь к #befreecommunity!\n",
            url = "https://runetstores.ru/sites/default/files/styles/large/public/stores/175.png?itok=4XVuyTOr",
            website = "http://www.befree.ru"
        )
        shops["DNS"] = Shop(name = "DNS",
            category = categoriesRepository.getCategoryNameById(3),
            description = "Деятельность группы компаний DNS всегда была направлена на удовлетворение потребностей каждого нашего покупателя, независимо от его социального статуса и финансовых возможностей. Желание угодить каждому нашему клиенту привело нас к созданию разных форматов магазинов, каждый из которых имеет свою историю, свою специфику и свои преимущества." +
                    "В ассортименте магазинов DNS Вы всегда сможете выбрать подходящий товар, а при возникновении вопросов получить профессиональную консультацию.\n",
            url = "https://cdn1.flamp.ru/58807a54c4c4c9c380989700d5abfcd9.JPG\n",
            website = "dns-shop.ru\n"
        )

        shops["ECCO"] = Shop(name = "ECCO",
            category = categoriesRepository.getCategoryNameById(1),
            description = "ECCO – один из мировых лидеров по производству обуви. Успех бренда базируется на трех китах: скандинавский дизайн, инновационные технологии и кожа премиум-качества, произведенная на собственных заводах. " +
                    "Продукция ECCO на сегодняшний день представлена в 2 250 магазинах и 14 000 точках продаж в 101 стране.\n",
            url = "https://imgbb.ru/frontend/posts/creation/2021-07-14/lbyyo26p7etun4zaxjpc7et2j30n1pmxhi3.jpg\n",
            website = "ecco.ru"
        )

    }
    fun addShop(shop: Shop) {
        shops[shop.name] = shop
    }

    fun removeShop(shopName: String) {
        shops.remove(shopName)
    }

    fun getShopByName(shopName: String): Shop? {
        return shops[shopName]
    }

    fun getAllShops(): Map<String, Shop> {
        return shops
    }
}