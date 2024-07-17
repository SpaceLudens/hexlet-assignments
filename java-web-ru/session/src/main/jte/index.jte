@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <body>
    <main>
        @if(page.getName() == null)
            <div>
                Вы не авторизованы
                <a href="/sessions/build">Войти</a>
            </div>
            @else
            <div>
                <h1>${page.getName().toString()}</h1>
                <input type="button" name="Выйти">
            </div>
        @endif

    </main>
    </body>
`
)
