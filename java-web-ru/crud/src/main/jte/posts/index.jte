@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
    <h1>Список постов</h1>
    @if(page.getPosts().isEmpty())
        <p>Список постов пуст</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h2>
                    <a href="${NamedRoutes.postsPath(post.getId())}">${post.getName()}</a>
                </h2>
            </div>
            @endfor
    @endif
    <nav aria-label="...">
        <ul class="pagination">
            <li>
                <a class="page-link" href="?page=${page.getPage() < 2 ? 1 : page.getPage() - 1}" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <li>
                <a class="page-link" href="?page=${page.getPage() > page.getPosts().size() ? 6 : page.getPage() + 1}">Next</a>
            </li>
        </ul>
    </nav>
`
)