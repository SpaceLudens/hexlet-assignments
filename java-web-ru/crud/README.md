## Создание CRUD на Javalin

### Ссылки

* [Методы работы с контекстом](https://javalin.io/documentation#context)
* [Пагинация в Bootstrap](https://getbootstrap.com/docs/5.0/components/pagination/)

### src/main/java/exercise/controller/PostsController.java

Реализуйте контроллер с двумя обработчиками.

Первый обработчик должен:

* Показывать страницу конкретного поста
* Отображать на ней данные поста
* Позволяет вернуться в список всех постов

Если поста не существует, то обработчик должен вернуть код ответа 404 и текст *Page not found*.

Второй обработчик должен:

* Показывать страницу со списком всех постов, причем каждый пост из списка должен вести на страницу конкретного поста. Посты выводятся в том порядке, в котором их возвращает метод репозитория
* Выводить список постов с пейджингом по 5 постов на странице. На первой странице первые пять постов, на второй пять и так далее
* Позволять переключаться между страницами с помощью двух ссылок — назад и вперед

То, какая сейчас страница открыта, определяется параметром строки запроса `page`. По умолчанию загружается первая страница.

Для получения сущностей с учетом пагинации в репозитории предусмотрен метод `findAll()`, который принимает первым параметром номер страницы, а вторым - размер страницы. Используйте его для получения постов из репозитория



### src/main/java/exercise/App.java

Опишите роутинг для просмотра списка всех постов */posts* и просмотра конкретного поста, например */posts/3*. Используйте именованные маршруты.

### src/main/jte/posts/index.jte

Выведите список добавленных постов. Каждый пост — это имя, представленное ссылкой, которая ведет на отображение.

### src/main/jte/posts/show.jte

Реализуйте вывод информации о конкретном посте.

### Подсказки

* Для формирования в шаблоне ссылок переключения страниц вам потребуется передать в шаблон помимо списка постов еще и номер текущей страницы
* Если хотите сделать красивый вывод в шаблонах, используйте классы Bootstrap
* Чтобы организовать ссылки для перелистывания страниц, передайте в шаблон текущий номер страницы