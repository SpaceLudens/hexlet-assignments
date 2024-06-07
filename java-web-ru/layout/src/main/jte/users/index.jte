@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        @for(var user : page.getUsers())
            <table>
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        ${user.getFirstName()}
                    </td>
                    <td>
                        ${user.getLastName()}
                    </td>
                </tr>
            </table>
        @endfor
    `
)