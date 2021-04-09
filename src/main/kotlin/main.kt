import com.fretron.model.User
import java.util.*

    fun main(){
        val serialize :Serialise = Serialise()
        val deserialise: Deserialise = Deserialise()
        var user = User()
        val list = mutableListOf<User>()

        list.add(User("abc" ,"asd122","xyz@gmail.com"))

        serialize.serialise(user,list)
      deserialise.deserialise(user)
    }