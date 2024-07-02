import org.example.Line
import org.example.Point
import org.example.Rectangle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class RectangleTest {
    val pointZero = Point(0.0, 0.0)
    val pointOne = Point(1.0, 0.0)
    val pointTwo = Point(1.0, 1.0)
    val pointThree = Point(-4.0, -3.0)

    @Test
    fun createRectangleTest() {
        val rectangle = Rectangle(listOf(pointZero, pointTwo))
        assertEquals(1.0, rectangle.getArea())
        assertEquals(1.0, rectangle.getHeight())
        assertEquals(1.0, rectangle.getWidth())

        val block : () -> Unit = { Rectangle(listOf(pointZero, pointOne)) }
        assertFailsWith<IllegalArgumentException> { block() }

        val block2 : () -> Unit = { Rectangle(listOf(pointTwo, pointOne)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}