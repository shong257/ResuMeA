package resume

import resume.Role
import resume.User
import resume.UserRole


class BootStrap {

/**    def init = { servletContext ->
*        createSaveAccount("Alba",  "Miranda")
*    }
**/
    def init = { servletContext ->
        Role roleUser = new Role(authority: 'ROLE_USER').save(failOnError: true)
        def createAccount = { String firstName, String lastName ->
            def User = new User(firstName: firstName, lastName: lastName, userName: firstName.toLowerCase(),
                    password: 'password').save(failOnError: true)
            UserRole.create User, roleUser
        }
        createAccount 'Harry', 'Potter'
        createAccount 'James', 'Dean'

    }


    def destroy = {
    }

    def createSaveAccount(name, password){
        def account = new UserAccount(userName : name, password : password).save()
        def profile = new Profile(ownerAccount : account).save()
//        def profile = new Profile(ownerAccount : account.getId()).save()
    }
}
