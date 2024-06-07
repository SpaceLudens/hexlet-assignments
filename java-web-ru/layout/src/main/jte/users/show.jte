@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h3>User description</h3>
        <div>ID: ${page.getUser().getId()}</div>
        <div>Fist name: ${page.getUser().getFirstName()}</div>
        <div>Last name: ${page.getUser().getLastName()}</div>
        <div>Email: ${page.getUser().getEmail()}</div>
`
)
