@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div>
            <label>
                Название статьи
                <input type="text" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div>
            <label for="content">Содержимое статьи</label>
            <textarea id="content" rows="5" cols="33"></textarea>
        </div>
        <input type="submit" value="Создать статью" />
    </form>
`
)