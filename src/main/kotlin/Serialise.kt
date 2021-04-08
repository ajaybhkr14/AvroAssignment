import com.fretron.model.User
import org.apache.avro.Schema
import org.apache.avro.file.DataFileWriter
import org.apache.avro.io.DatumWriter
import org.apache.avro.specific.SpecificDatumWriter
import java.io.File

    fun main(){
        val empDatumWriter: DatumWriter<Any> = SpecificDatumWriter(User().javaClass)
        val empFileWriter: DataFileWriter<Any> = DataFileWriter(empDatumWriter)
        empFileWriter.create(Schema.Parser().parse(File("./src/main/avro/user.avsc")),
            File("src/main/avro/user.avro"))

        var user =User()
       // user.setEmail("abc@gmail.com")
        user.setFirstName("ajay")
        user.setId("asfa12")
        empFileWriter.append(user)
        empFileWriter.close()
    print(user)
}