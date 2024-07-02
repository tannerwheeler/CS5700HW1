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

    @Test
    fun testGetArea() {
        var rectangle = Rectangle(listOf(pointZero, pointThree))
        assertEquals(12.0, rectangle.getArea())

        rectangle = Rectangle(listOf(pointOne, pointThree))
        assertEquals(15.0, rectangle.getArea())

        rectangle = Rectangle(listOf(pointTwo, pointThree))
        assertEquals(20.0, rectangle.getArea())
    }

    @Test
    fun testGetHeight() {
        var rectangle = Rectangle(listOf(pointZero, pointThree))
        assertEquals(3.0, rectangle.getHeight())

        rectangle = Rectangle(listOf(pointOne, pointThree))
        assertEquals(3.0, rectangle.getHeight())

        rectangle = Rectangle(listOf(pointTwo, pointThree))
        assertEquals(4.0, rectangle.getHeight())
    }

    @Test
    fun testGetWidth() {
        var rectangle = Rectangle(listOf(pointOne, pointThree))
        assertEquals(5.0, rectangle.getWidth())

        rectangle = Rectangle(listOf(pointTwo, pointThree))
        assertEquals(5.0, rectangle.getWidth())

        rectangle = Rectangle(listOf(pointZero, pointThree))
        assertEquals(4.0, rectangle.getWidth())
    }
}