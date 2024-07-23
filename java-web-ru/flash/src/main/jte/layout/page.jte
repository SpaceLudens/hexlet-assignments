@import exercise.util.NamedRoutes
@import gg.jte.Content
@import exercise.dto.BasePage

@param Content content
@param BasePage page = null
<!-- BEGIN -->


<!doctype html>
<html lang="ru">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Main page</title>
</head>
<div>
    <li><a href="${NamedRoutes.postsPath()}" class="nav-link px-2 link-dark">Posts</a></li>
</div>
<body>
<div class="mx-auto p-4 py-md-5">
    @if(page != null && page.getFlash() != null)
            <div class="alert alert-success" role="alert">
                <p>${page.getFlash()}</p>
            </div>
    @endif
    ${content}
</div>
</body>
</html>

<!-- END -->
