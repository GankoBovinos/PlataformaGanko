package ganko.movil.ganko1.data.model

/**
 * Created by Cristian on 21/10/2017.
 */
class UserLogin (var username:String,var password:String)
class UserResponse(var id: Int,var username: String,var estado: String)
class LoginResponse(var user:UserResponse,var token:String)
class ResetPasswordResponse(var email:String,var estado:String)
class ResetUserEmail(var email:String)