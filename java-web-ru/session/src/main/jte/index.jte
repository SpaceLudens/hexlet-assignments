@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    <body>
    <main>
        @if(page.getName() == null)
            <div>
                Вы не авторизованы
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            </div>
            @else
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <h1>${page.getName().toString()}</h1>
                    <input type="submit" name="Выйти"/>
                </form>
        @endif

    </main>
    </body>
`
)
