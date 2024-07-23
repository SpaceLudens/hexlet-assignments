@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <form action="${NamedRoutes.postsPath()}" method="get">
        <input type="search" name="term" value="${page.getTerm()}">
        <input type="submit" value="Search">
    </form>
    <div style="row row-cols-md-3 mb-3">
        <h2>Posts list</h2>
        <table class="table table-striped">
            @if(page.getPosts().isEmpty())
                <p>No posts have been added yet</p>
            @else
                <tr >
                    <th >ID</th>
                    <th>Name</th>
                    <th>Body</th>
                </tr>
                @for(var user : page.getPosts())
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getName()}</td>
                        <td>${user.getBody()}</td>
                    </tr>
                @endfor
            @endif
        </table>
        <li><a href="${NamedRoutes.buildPostPath()}">Add new post</a></li>
    </div>
`
)