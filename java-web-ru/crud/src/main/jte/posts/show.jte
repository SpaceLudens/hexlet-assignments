@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div>ID: ${page.getPost().getId()}</div>
    <div>Название: ${page.getPost().getName()}</div>
    <div>Описание: ${page.getPost().getBody()}</div>
    <a href="${NamedRoutes.postsPath()}">Вернуться</a>
`
)