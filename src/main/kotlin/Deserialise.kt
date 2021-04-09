import org.apache.avro.io.DatumReader
import org.apache.avro.specific.SpecificDatumReader
import org.apache.avro.file.DataFileReader
import java.io.File


class Deserialise {

    fun deserialise(clazz: Any){
        val userDataReader :DatumReader<Any> =SpecificDatumReader(clazz.javaClass)
        val dataFileReader : DataFileReader<Any> = DataFileReader(File("./src/main/avro/user.avro"),userDataReader)
        var obj :Any? =null
        obj =dataFileReader.next(obj)
        println(obj)
    }
}