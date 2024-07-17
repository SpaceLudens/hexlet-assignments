@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@if(page == null)
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text"  name="name" placeholder="Name" />
        <input type="password" name="password" placeholder="Password" />
        <input type="submit" />
    </form>
@else
    <form action="${NamedRoutes.loginPath()}" method="post">
        <h1>${page.getError()}</h1>
        <input type="text" name="name" placeholder="${page.getName()}" />
        <input type="password" name="password" placeholder="Password" />
        <input type="submit" />
    </form>
@endif
