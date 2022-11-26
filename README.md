# BookShopApp
 This is Internet-market where you can buy books
 ALPHA BSh_1.0.5(in working)

На данный момент реализованы:

-Контроллеры(/src/main/java/com.wizardVadim.BookShopApp/controllers)

-Конфиг локализации(/src/main/java/com.wizardVadim.BookShopApp/config/LocaleChangeConfig.java)

-Объекты и сервисы(/src/main/java/com.wizardVadim.BookShopApp/data)

-Frontend(готовый, проводилась только работа с thymeleaf над HTML-файлами для динамической работы сайта, fragments, lang - настройки локализации)(path: /src/main/resources/spring-frontend)

-Файл конфигурации spring(Дополнение для тестовой реализации базы данных)

-Файлы конфигурации базы данных (Таблицы books, authors)


Описание контроллеров и их работы:

-AccountController.java - класс для работы с запросами связанными с логикой профилей, содержимого профилей

-AuthorController.java - класс для работы с запросами связанными с логикой взаимодействия с объектами Author

-AuthorizationController.java - класс для работы с запросами связанными с входом, выходом и регистрацией профилей

-BookController.java - класс для работы с запросами связанными с логикой взаимодействия с объектами Book

-DocumentController.java - класс для работы с запросами связанными с логикой взаимодействия с документами

-GenreController.java - класс для работы с запросами связанными с логикой взаимодействия с объектами Genre

-MainPage.java - класс для работы с запросами связанными с отображением начальной (главной) страницы


Описание объектов:

-Book.java - класс для работы с представлением книг в таблице books

-Author.java - класс для работы с представлением авторов книг в таблице authors


Описание сервисов:

-BookService.java - класс для работы с базой данных, таблицей books, выполнение запросов

-AuthorService.java - класс для работы с базой данных, таблицей authors, выполнение запросов


Дополнение:
Проект по реализации книжного магазина.

В этом проекте я практиковался на реализации backend с испозованием Spring-технологий. Frontend был реализован не мной, он был лишь написан для дополнения backend-ом и базами данных. 


Мною использованы технологии: 

-Java

-Spring Boot

-Thymeleaf

-Sql (H2-DataBase)

