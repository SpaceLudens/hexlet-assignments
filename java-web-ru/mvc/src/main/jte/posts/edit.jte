@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div>
        <h1>Редактировать пост</h1>
        <div class="mx-auto p-4 py-md-5">
            <form action="/posts/${page.getPost().getId()}/edit" method="post">
                <div class="mb-3">
                    <label class="form-label">
                        Название
                        <input type="text" class="form-control" name="name" value="${page.getPost().getName()}" />
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">Содержание</label>
                    <textarea class="form-control" rows="20" cols="70" type="text" name="body">${page.getPost().getBody()}</textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Сохранить" />
            </form>
    </div>
`
)

