import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import junit.framework.TestCase.assertEquals
import org.junit.Test

data class Cars(val brand: String, val country: String)

class JsonSerialization {
    private val objectMapper = ObjectMapper().registerKotlinModule()

    fun serializeToJson(car: Cars): String {
        return objectMapper.writeValueAsString(car)
    }

    fun deserializeFromJson(jsonString: String): Cars {
        return objectMapper.readValue(jsonString)
    }
}
class JsonSerializationTest {
    @Test
    fun testSerializeToJson() {
        val car = Cars("LADA", "Russia")
        val jsonSerialization = JsonSerialization()
        val jsonString = jsonSerialization.serializeToJson(car)
        assertEquals("{\"brand\":\"LADA\",\"country\":\"Russia\"}", jsonString)
    }

    @Test
    fun testDeserializeFromJson() {
        val jsonString = "{\"brand\":\"BMW\",\"country\":\"Germany\"}"
        val jsonSerialization = JsonSerialization()
        val car = jsonSerialization.deserializeFromJson(jsonString)
        assertEquals(Cars("BMW", "Germany"), car)
    }
}