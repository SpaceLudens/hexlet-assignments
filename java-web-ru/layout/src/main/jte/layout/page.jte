@import exercise.model.User
@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>

<div class="form-control-dark">
    <div class="header-right">
        <a href="/">Start page</a>
        <a href="/users">Users</a>
    </div>
</div>

<body>
    ${content}
</body>

<footer>
    <p><a href="https://github.com/dashboard">GitHub link</a></p>
</footer>

</html>