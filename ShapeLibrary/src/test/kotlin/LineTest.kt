import org.example.Line
import org.example.Point
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class LineTest {
    val pointZero = Point(0.0, 0.0)
    val pointOne = Point(1.0, 0.0)
    val pointTwo = Point(1.0, 1.0)
    val pointThree = Point(-4.0, -3.0)

    @Test
    fun testCreateLine() {
        val line = Line(pointZero, pointOne)
        assertEquals(0.0, line.startPoint.x)
        assertEquals(0.0, line.startPoint.y)
        assertEquals(1.0, line.endPoint.x)
        assertEquals(0.0, line.endPoint.y)

        val block : () -> Unit = {Line(pointZero, pointZero)}
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testGetSlope() {
        val line = Line(pointTwo, pointThree)
        val slope = line.getSlope()
        assertEquals(4.0/5.0, slope)
    }

    @Test
    fun testGetLength() {
        val line = Line(pointZero, pointThree)
        val length = line.getLength()
        assertEquals(5.0, length)
    }
}