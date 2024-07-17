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
            <div>
                <h1>${page.getName().toString()}</h1>
                <a href="${NamedRoutes.logoutPath()}">Выйти</a>
            </div>
        @endif

    </main>
    </body>
`
)
