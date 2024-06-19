@import exercise.dto.posts.EditPostPage
@param EditPostPage page

@template.layout.page(
content = @`
    <div>
        <h1>Редкатировать пост ${page.getPost().getName()}</h1>
    </div>
`
)

