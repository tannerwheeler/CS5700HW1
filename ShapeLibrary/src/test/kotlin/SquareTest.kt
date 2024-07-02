import org.example.Point
import org.example.Square
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class SquareTest {
    val pointZero = Point(0.0, 0.0)
    val pointZero2 = Point(1.0, 1.0)
    val pointOne = Point(1.0, 0.0)
    val pointTwo = Point(0.0, 1.0)
    val pointThree = Point(-4.0, -4.0)

    @Test
    fun createSquareTest() {
        val square = Square(listOf(pointZero, pointZero2))
        assertEquals(1.0, square.getArea())
        assertEquals(1.0, square.getHeight())
        assertEquals(1.0, square.getWidth())

        val square2 = Square(listOf(pointTwo, pointOne))
        assertEquals(1.0, square2.getArea())
        assertEquals(1.0, square2.getHeight())
        assertEquals(1.0, square2.getWidth())

        val block : () -> Unit = { Square(listOf(pointZero, pointZero.clone())) }
        assertFailsWith<IllegalArgumentException> { block() }

        val block2 : () -> Unit = { Square(listOf(pointZero, pointOne)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testGetArea() {
        var square = Square(listOf(pointZero, pointThree))
        assertEquals(16.0, square.getArea())

        square = Square(listOf(pointTwo, pointOne))
        assertEquals(1.0, square.getArea())
    }

    @Test
    fun testGetHeight() {
        var square = Square(listOf(pointZero, pointThree))
        assertEquals(4.0, square.getHeight())

        square = Square(listOf(pointOne, pointTwo))
        assertEquals(1.0, square.getHeight())
    }

    @Test
    fun testGetWidth() {
        var square = Square(listOf(pointZero, pointThree))
        assertEquals(4.0, square.getWidth())

        square = Square(listOf(pointOne, pointTwo))
        assertEquals(1.0, square.getWidth())
    }
}