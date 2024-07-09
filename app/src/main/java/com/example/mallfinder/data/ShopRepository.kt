package com.example.mallfinder.data


object ShopRepository {
    private val categoriesRepository = CategoryRepository
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

        shops["ECRU"] = Shop( name = "ECRU",
            category = categoriesRepository.getCategoryNameById(1),
            description = "ECRU представляет особое нестандартное видение современной уличной моды.\n" +
                    "Вдохновленный ритмом больших городов, бренд предлагает коллекции одежды, обуви и аксессуаров для тех, кто хочет выражать себя и свою индивидуальность. ECRU ориентируется на прогрессивную молодую аудиторию, которая любит городскую среду, следит за музыкальными новинками и не боится экспериментировать с последними модными трендами.",
            url = "https://ib.gipernn.ru/bc7adaaqcmzdu_eny5t2.jpeg",
            website = "ecrubrand.com"
        )

        shops["EKONIKA"] = Shop(name = "EKONIKA",
            category = categoriesRepository.getCategoryNameById(2),
            description = "КОЛЛЕКЦИЯ БРЕНДА ВКЛЮЧАЕТ ТРИ МАРКИ: EKONIKA. Базовая линия отражает характер и стиль бренда. EKONIKA PREMIUM. Премиальная линия привлекает внимание своими необычными акцентами и изяществом исполнения. PORTAL. Смелые решения, актуальные цвета и фактуры, стильная обувь и аксессуары для яркой и многогранной девушки.",
            url = "https://static.wr.market/upload/shops/1453/bf1efed4bbcd935853ce9c1b9eae27c8.jpg",
            website = "ekonika.ru"
        )

        shops["GLORIA JEANS"]= Shop(name = "GLORIA JEANS",
            category = categoriesRepository.getCategoryNameById(1),
            website = "gloria-jeans.ru",
            description = "Магазины Gloria Jeans работают более чем в 300 городах, и сеть растет с каждым днем.История бренда началась около 40 лет назад с небольшого предприятия и воплощения мечты миллионов людей в реальность. Джинсы как символ свободы стали доступны каждому.",
            url = "https://static.cashback.mts.ru/cards/404m4loloybjlfw_gjjj.jpg"
        )

        shops["GLЭМ"] =Shop(name = "GLЭМ",
            category = categoriesRepository.getCategoryNameById(1),
            website = "",
            description = "GLЭМ — это не только мода, но и стиль жизни.Все самые современные тенденции сезона. Модели на любой случай жизни: от гламурных и традиционных, до классических, которые подчеркнут Ваш стиль, достоинства и индивидуальность.",
            url = "https://mbkazan.ru/storage/snimok-ekrana-2019-11-07-v-17-15-42.png"
        )

        shops["LOVE REPUBLIC"]= Shop(name = "LOVE REPUBLIC",
            category = categoriesRepository.getCategoryNameById(1),
            website = "loverepublic.ru",
            description = "Девушка LOVE REPUBLIC уверена в себе и амбициозна. Она умеет наслаждаться каждым моментом и знает, что такое истинный гедонизм. Образы, которые она выбирает, помогают раскрыть её внутреннюю энергию.",
            url = "https://lh3.googleusercontent.com/YU-srwX40PZUoBnpsPkz0fJlQZv8SKpdP6fkKmurVUWublqk1AjoF5tchuVdRv2chDM=h500"
        )

        shops["MANGO"] = Shop(name = "MANGO",
            category = categoriesRepository.getCategoryNameById(1),
            website = "mango.com",
            description = "MANGO — испанская торговая марка модной женской одежды и аксессуаров. Ассортимент ее основан на следующих направлениях: повседневная одежда, вечерняя и классическая. Каждое из этих направлений состоит из множества стилей, дизайнерских решений и различных моделей, что позволяет Mango одевать женщину на все случаи жизни. Концепция успеха бренда основана на устойчивом альянсе между качеством продукции, чутким пониманием последних тенденций в мире моды и доступной ценой.",
            url = "https://www.terracity.com.tr/fileadmin/user_upload/GLOBAL/brand_stores/logos/mango.jpg"
        )

        shops["NAM"] = Shop(name = "NAM",
            category = categoriesRepository.getCategoryNameById(2),
            website = "obuvnam.ru",
            description = "Обувная компания NAM — это стильная, качественная и доступная обувь: женская, мужская и детская. Особое внимание в магазинах NAM уделяется соотношению цены/качества и актуальным модным трендам. Широкий, постоянно обновляющийся ассортимент, от изысканной классики до спортивных моделей, позволит найти обувь для любого случая.",
            url = "https://avatars.mds.yandex.net/get-altay/6197788/2a0000018369c19e0ab7c414967a342cc868/orig"
        )

        shops["O’STIN"] = Shop(name = "O’STIN",
            category = categoriesRepository.getCategoryNameById(2),
            website = "ostin.com",
            description = "O′STIN – международный бренд модной одежды для женщин, мужчин и детей.",
            url = "https://www.belpromsvet.ru/upload/iblock/dcb/dcbc6fb74dd87afe6da018f408166fca.jpg"
        )

        shops["POLARIS"] = Shop(name = "POLARIS",
            category = categoriesRepository.getCategoryNameById(3),
            website = "shop-polaris.ru",
            description = "Polaris – международный бренд бытовой техники, основным направлением деятельности которого является производство малой бытовой техники, теплового оборудования, водонагревателей, климатической техники, посуды.",
            url = "https://s.rbk.ru/v1_companies_s3/resized/1200xH/media/trademarks/9c3ef9f0-d280-41b8-8635-47b64dbf1266.jpg"
        )

        shops["SALAMANDER"] = Shop(name = "SALAMANDER",
            category = categoriesRepository.getCategoryNameById(2),
            website = "salamander.ru",
            description = "Каждый сезон магазин Salamander представляет широкий выбор обуви: красивая и стильная, которая продумана до мелочей истинными ценителями и творцами обувной промышленности. Эта shoes удобная и практичная, женственная и элегантная.",
            url = "https://skidkimira.ru/images/company/edae27d6-be5f-498f-9d6c-af4251087bd9.jpg"
        )

        shops["ZARINA"] = Shop(name = "ZARINA",
            category = categoriesRepository.getCategoryNameById(1),
            website = "zarina.ru",
            description = "Сегодня ZARINA — это стильный капсульный гардероб на каждый день по доступным ценам для миллионов женщин и мужчин. Мы создаём моду вне времени и производим вдохновляющую одежду, которая отражает индивидуальный стиль наших покупателей.",
            url = "https://spclub23.ru/files/bd1/bd12d690c9522165a906e271e29cebfa.jpg"
        )

        shops["АШАН"] = Shop(name = "АШАН",
            category = categoriesRepository.getCategoryNameById(5),
            website = "auchan.ru",
            description = "АШАН признанный лидер среди гипермаркетов в России, который «сразил» российских покупателей своей концепцией: продавать по самым низким ценам все большее количество качественных продовольственных и непродовольственных товаров все большему числу покупателей, и тем самым повышать покупательскую способность российских потребителей.",
            url = "https://sun9-46.userapi.com/impf/c629305/v629305172/122ac/mybHk2FYsKs.jpg?size=1001x600&quality=96&sign=51d1e889a21409d25155d048178eb7a3&c_uniq_tag=Ft9BepMe0-FnYQ5V-7EHjo_9Za7AsumuG-paPCyhg7c&type=album"
        )

        shops["ЗОЛОТОЕ ЯБЛОКО"] = Shop(name = "ЗОЛОТОЕ ЯБЛОКО",
            category = categoriesRepository.getCategoryNameById(4),
            website = "goldapple.ru",
            description = "«Золотое Яблоко» — бьюти-супермаркет с огромным ассортиментом косметики, парфюмерии и не только.",
            url = "https://complaintbook.ru/wp-content/uploads/2020/02/2E8AA8C9-EC0A-4315-925A-1827272D839F.jpeg"
        )

        shops["КОРД ОПТИКА"] = Shop(name = "КОРД ОПТИКА",
            category = categoriesRepository.getCategoryNameById(4),
            website = "vk.com/kordoptika",
            description = "В салонах Корд Оптики представлены медицинские оправы, мягкие контактные линзы, солнцезащитные очки и линзы для очков. Подберите качественный товар по демократичным ценам в сети салонов. Надежно оберегать зрение клиентов — миссия компании.",
            url = "https://img.hhcdn.ru/zp-image/aHR0cHM6Ly9jZG41LnpwLnJ1L2pvYi9hdHRhY2hlcy8yMDIwLzA3L2M2L2MxL2M2YzE5ZGZmM2E0ZDkwOTY3ODhiZjIzZTljOWY0NTBk.jpg"
        )

        shops["Л’ЭТУАЛЬ"] = Shop(name = "Л’ЭТУАЛЬ",
            category = categoriesRepository.getCategoryNameById(4),
            website = "letu.ru" ,
            description = "Л’Этуаль — лидер парфюмерно-косметической индустрии в России. Вот уже 25 лет мы радуем клиентов лучшим сервисом и лучшим ассортиментом, профессиональными рекомендациями и экспертным подходом. У нас 1000 магазинов от Калининграда до Владивостока, и каждый из них — это комфортное пространство для увлекательного бьюти-шопинга.",
            url = "https://papik.pro/grafic/uploads/posts/2023-04/1681514563_papik-pro-p-letual-logotip-vektor-37.jpg"
        )

        shops["ЛЕНТА"] = Shop(name = "ЛЕНТА",
            category = categoriesRepository.getCategoryNameById(5),
            website = "lenta.com",
            description = "ЛЕНТА – лучшее место для Ваших покупок! Всё, что нужно для разнообразного меню и уютного дома: более 30 000 продовольственных и непродовольственных товаров, включая продукцию собственного производства и местных производителей.",
            url = "https://gas-kvas.com/grafic/uploads/posts/2024-01/gas-kvas-com-p-logotip-lenta-na-prozrachnom-fone-3.png"
        )

        shops["М.ВИДЕО"] = Shop(name = "М.ВИДЕО",
            category = categoriesRepository.getCategoryNameById(3),
            website = "mvideo.ru",
            description = "«М.Видео» — крупнейшая розничная сеть по объёмам продаж электроники и бытовой техники в России. «М.Видео» осуществляет свою деятельность с 1993 года и сегодня управляет более чем 400 магазинами в 169 городах Российской Федерации по всей России от Калининграда до Владивостока.",
            url = "https://kali24.ru/wp-content/uploads/2023/12/07e92d8619549a9431cc3.jpg"
        )

        shops["МОНРО"] = Shop(name = "МОНРО",
            category = categoriesRepository.getCategoryNameById(2),
            website = "monro.ru",
            description = "В течение всей своей истории компания ориентировалась на потребности покупателей. При этом неизменной суммой преимуществ обуви компании МОНРО всегда оставались и остаются: демократичные цены, качество и большой ассортимент. Именно эти ценности компания бережно сохраняет и стремится донести до потребителя.",
            url = "https://postila.ru/data/9c/89/3e/f7/9c893ef737a14359bde1b6cba18613e4655bc759824c6325de487c06c14ca931.jpg"
        )
        shops["ПЕРЕКРЕСТОК"] =Shop(name = "ПЕРЕКРЕСТОК",
            category = categoriesRepository.getCategoryNameById(5),
            website = "perekrestok.ru",
            description = "Супермаркет Перекресток",
            url = "https://telegra.ph/file/6c89e68b7aa5dea33cad3.jpg"
        )

        shops["ТВОЕ"] = Shop(name = "ТВОЕ",
            category = categoriesRepository.getCategoryNameById(1),
            website = "tvoe.ru",
            description = "ТВОЕ — российский бренд одежды, обуви и аксессуаров. Собственные производственные площадки компании расположены в России, Белоруссии и Молдавии, розничная сеть насчитывает более 300 магазинов в четырех странах СНГ. Бренд занимает лидирующие позиции в сегменте по продажам online.",
            url = "https://gallery-grand.by/wp-content/uploads/2018/07/logo_twoe.jpg"
        )

        shops["ЭЛЬДОРАДО"] = Shop(name = "ЭЛЬДОРАДО",
            category = categoriesRepository.getCategoryNameById(3),
            website = "eldorado.ru",
            description = "«Эльдорадо» представляет широкий ассортимент качественных товаров ведущих мировых брендов, который насчитывает свыше 20 000 наименований в 110 товарных группах. Стратегическое партнерство с ведущими международными производителями позволяет клиентам «Эльдорадо» в числе первых узнавать о впечатляющих инновациях и получать эксклюзивные новинки.",
            url = "https://koshelek-card.ru/wp-content/uploads/2019/12/eldorado-bonusnaya-karta-1024x746.png"
        )

    }
    fun addShop(shop: Shop) {
        shops[shop.name] = shop
    }

    fun removeShop(name: String) {
        shops.remove(name)
    }

    fun getShopByName(name: String): Shop? {
        return shops[name]
    }

    fun getAllShops(): Map<String, Shop> {
        return shops
    }
}