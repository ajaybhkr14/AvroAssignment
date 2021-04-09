import com.fretron.model.User
import org.apache.avro.Schema
import org.apache.avro.file.DataFileWriter
import org.apache.avro.io.DatumWriter
import org.apache.avro.specific.SpecificDatumWriter
import java.io.File
class Serialise{
    fun <T>serialise(clazz: Any ,list: MutableList<T>){
        val empDatumWriter: DatumWriter<Any> = SpecificDatumWriter(clazz.javaClass)
        val empFileWriter: DataFileWriter<Any> = DataFileWriter(empDatumWriter)
        empFileWriter.create(Schema.Parser().parse(File("./src/main/avro/user.avsc")),
            File("src/main/avro/user.avro"))

        empFileWriter.append(list[0])
        empFileWriter.close()
    println("Serialised successfully")

}}