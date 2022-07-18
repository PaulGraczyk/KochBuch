INSERT INTO category
    (category_shortcut, category_title, description)
VALUES ('vege', 'Dania wegetariańskie',
        'PRZEPISY WEGETARIAŃSKIE NA OBIAD TO MNÓSTWO SMAKU I AROMATU ORAZ WITAMIN I MIKROELEMENTÓW.
        JEŻELI NIE JADASZ MIĘSA, WŁAŚNIE TU ZNAJDZIESZ NAJLEPSZE PRZEPISY, KTÓRE GO NIE ZAWIERAJĄ.'),
       ('meat', 'Dania mięsne', 'MIĘSO TO SKŁADNIK WIELU NASZYCH POSIŁKÓW. NIE MA W TYM NIC ZŁEGO -
                                TO ŹRÓDŁO PEŁNOWARTOŚCIOWEGO BIAŁKA, BARDZO NAM POTRZEBNEGO. MIĘSO DAJE SIĘ PRZYRZĄDZAĆ NA MILION SPOSOBÓW -
                                OD BARDZO PROSTYCH I SZYBKICH, PO WYMYŚLNE I EFEKTOWNE.'),
       ('dumplings', 'Pierogi',
        'KLASYCZNE PIEROGI. NIE MOŻNA SIĘ BEZ NICH OBYĆ. ZNAJDZIESZ TU ZARÓWNO TRADYCYJNE PRZEPISY, JAK RÓWNIEŻ BARDZIEJ INNOWACYJNE.'),
       ('other', 'Inne', 'TU ZNAJDZIESZ PRZEPISY, KTÓRE NIE PASUJĄ DO POZOSTAŁYCH KATEGORII.');

INSERT INTO recipe
    (recipe_Name, ingredients, description, number_of_likes, category_id, date_added, is_gluten_free)
VALUES ('Frytki z batatów',
        '2 średnie bataty - 850 g, 2 płaskie łyżki skrobi kukurydzianej lub ziemniaczanej, 2 płaskie łyżki skrobi kukurydzianej lub ziemniaczanej, garść siekanej natki pietruszki przyprawy: po 1 płaskiej łyżce suszonego czosnku i słodkiej papryki, płaska łyżeczka soli, pół płaskiej łyżeczki pieprzu',
        'Piekarnik nagrzać do 220 stopni C. Przygotować dużą blachę (np. z wyposażenia piekarnika) i wyłożyć ją papierem do pieczenia. Batata obrać i pokroić na cienkie słupki. Obtoczyć je w oliwie, następnie doprawić pieprzem (solimy dopiero na koniec, po upieczeniu), papryką, czosnkiem, oregano. Dodać skrobię ziemniaczaną i wymieszać.
        Bataty ułożyć na blaszce z zachowaniem odstępów. Posypać listkami rozmarynu (opcjonalnie). Wstawić do piekarnika i piec przez ok. 20 - 23 minuty.
        Po upieczeniu posypać posiekaną natką, a przed podaniem doprawić solą.', 30, 1, '2020-07-15', true),
       ('Kotlety z bobu',
        ' 300 g bobu (waga po ugotowaniu i obraniu), 2 jajka, 5 łyżek panierki panko lub bułki tartej, 1 ząbek czosnku, 1 łyżeczka oliwy extra',
        'Bób wrzucić na osolony wrzątek i gotować do miękkości (ok. 10 - 30 minut, w zależności od tego czy jest młody czy dojrzały, odcedzić, obrać z łupinek i odmierzyć 300 g, w większej misce wymieszać 1 jajko z 4 łyżkami panierki lub bułki tartej, dodać przeciśnięty przez praskę czosnek,
        oliwę, sok z cytryny, miętę i posiekaną cebulką, dodać obrany bób, rozgnieść go widelcem (niekoniecznie dokładnie) i połączyć ze składnikami w misce, można też dodać tahini i kmin
        uformować nieduże kotleciki, obtoczyć w roztrzepanym jajku i delikatnie obtoczyć w pozostałej łyżce panierki, usmażyć na oleju z dwóch stron (krótko, na złoty kolor). Podawać z tzatziki lub jogurtem z miętą.',
        452, 1, '2021-01-10', true),
       ('Pieczeń rzymska z udźca indyka',
        'Udziec z indyka bez kości, przyprawa do mięsa mielonego Knorr, jajka, kajzerki namoczone w mleku, przyprawa pikantna grubo mielona Knorr, natka pietruszki, zielone oliwki, czarne oliwki, ser feta.',
        'Mięso z indyka zmiel na grubych oczkach (możesz tez użyć gotowego mięsa mielonego) i połącz z odciśniętymi kajzerkami.
        Do mięsa dodaj łyżeczkę przyprawy grubo mielonej, 2 jajka, posiekaną natką pietruszki, pokrojone w plasterki oliwki, pokrojony w grubą kostkę ser feta oraz Przyprawę do mięsa mielonego Knorr dla podkreślenia smaku. Całość delikatnie wymieszaj.
        Połowę farszu ułóż w formie do ciasta wyłożonej pergaminem. Po środku zrób małe wgłębienie. Ułóż pozostałe 5 ugotowanych na twardo i obranych jaj. Całość przykryj pozostałą częścią farszu.
        Pieczenią postukaj upuszczając ją na blat kilka razy, aby farsz dobrze się ułożył w foremce. Wstaw do nagrzanego do 180°C piekarnika na 90 minut.',
        55, 2, '2022-03-17', true),
       ('Ciasto na pierogi', '300 g mąki pszennej, szczypta soli, 125 ml wrzącej wody, 1 jajko, 20 g masła',
        'Mąkę wsypać do miski, dodać sól. Do wrzącej wody włożyć masło i roztopić, stopniowo wlewać do mąki, mieszając wszystko łyżką.
        W międzyczasie dodać roztrzepane jajko i połączyć wszystkie składniki, zagnieść gładkie ciasto.
        Wyłożyć na podsypany mąką blat i wygniatać przez około 7 - 8 minut. Zawinąć w folię i odstawić na ok. 30 minut.
        Ciasto podzielić na 4 części i kolejno rozwałkowywać na cienki placek (około 2 - 3 mm), obsypując w razie potrzeby stolnicę mąką.
        Małą szklanką wycinać kółka, rozciągnąć je trochę w palcach, następnie na środek nakładać po jednej czubatej łyżeczce farszu.
        Składać na pół i zlepiać dokładnie brzegi, układać na stolnicy.
        W dużym garnku zagotować osoloną wodę i jak będzie mocno wrzała, włożyć pierwszą partię pierogów (około 15 sztuk).
        Po ponownym zagotowaniu zmniejszyć ogień do średniego i gotować pierożki przez około 2 minuty licząc od czasu wypłynięcia ich na powierzchnię wody (do czasu aż ciasto będzie miękkie, sprawdzamy palcem wyławiając jednego pieroga).
        Długość gotowania zależy od grubości ciasta. Wyłowić łyżką cedzakową na talerz.', 115, 3, '2022-07-17', false),
       ('Pierogi z filetem z kurczaka i suszonymi pomidorami',
        '1 podwójny filet z kurczaka, 2 – 3 łyżki oliwy, 5 – 7 suszonych pomidorów, 5 – 7 dużych liści świeżej bazylii, 4 ząbki czosnku, 2 łyżki masła, sól',
        'Piersi z kurczaka pokroiłam i usmażyłam na złoty kolor, na oliwie. Patelni nie myłam odstawiłam ją (będzie nam jeszcze potrzebna). Po usmażeniu dodałam pokrojone suszone pomidory i bazylię. Na drugiej patelni roztopiłam masło i wrzuciłam na nie ząbki czosnku w łupinach. Smażyłam po minucie z każdej strony. Po wystudzeniu, obrałam i dodałam do mięsa. Mięso wraz z dodatkami dokładnie zblendowałam na gładką masę i posoliłam do smaku.
        Na stolnice przesiałam mąkę, zrobiła w niej dołek, wlałam ciepłą wodę, dodałam masło, posoliłam i zagniotłam elastyczne ciasto. Ciasto rozwałkowałam i pokroiłam na kawałki. Łyżką nakładałam farsz i zlepiałam pierogi. Zagotowałam wodę, do wrzątku wrzucałam pierogi, wyciągałam je 2 minuty po wypłynięciu na wierzch. Na patelni na której smażyłam kurczaka roztopiłam masło, dodałam sól, posiekany rozmaryn i szałwię. Trzymałam na średnim ogniu około 2 minut. Pierogi podałam polane masłem rozmarynowo-szałwiowym.',
        233, 3, '2021-09-20', true),
       ('Brownie z kokosowym pudrem',
        '2 jajka, 3 łyżki cukru, 70 g ciemnej czekolady, 140 g masła,  80 ml mleka, 170 g mąki, 2 łyżki kakao, 1 łyżeczka proszku do pieczenia',
        'Rozgrzewamy piekarnik do 170ºC. Prostokątną formę o wymiarach ok. 20×30 cm smarujemy masłem i wykładamy papierem do pieczenia.
        Całe jajka oraz cukier roztrzepujemy trzepaczką lub miksujemy, ale tylko do lekkiego spienienia jajek. W międzyczasie roztapiamy masło i czekoladę (polecam dodać kilka kostek czekolady miętowej, ciasto zyska na smaku). Do masy jajecznej dodajemy mleko, wlewamy roztopione masło z czekoladą i przesiewamy mąkę, kakao i proszek do pieczenia.
        Wszystkie składniki mieszamy do połączenia (nie za długo) i przelewamy do blaszki. Ciasto wstawiamy do piekarnika i pieczemy około 20 minut (do suchego patyczka).
        Po upieczeniu ciasto studzimy w formie. Gdy lekko przestygnie, możemy zacząć przygotowywać polewę. Czekoladę oraz śmietankę podgrzewamy i mieszamy do połączenia. Wierzch ciasta polewamy czekoladą.
        Wiórki kokosowe rozdrabniamy w malakserze lub młynku do kawy, mieszamy z cukrem pudrem i za pomocą sitka lub przesiewacza do mąki posypujemy ciasto. Deser kroimy na porcje.',
        177, 4, '2022-06-25', false);




