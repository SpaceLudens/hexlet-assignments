@import exercise.dto.users.UserPage
@param UserPage page

<html>
<body>
<p>${"User ID: " + page.getUser().getId()}</p>
<p>${"User first name: " + page.getUser().getFirstName()}</p>
<p>${"User last name: " + page.getUser().getLastName()}</p>
<p>${"User Email: " + page.getUser().getEmail()}</p>
</body>
</html>
