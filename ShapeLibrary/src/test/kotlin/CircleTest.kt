import org.example.Circle
import org.example.Point
import org.example.Square
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.math.PI

class CircleTest {
    var pointZero = Point(0.0, 0.0)
    val pointOne = Point(0.0, 1.0)
    val pointTwo = Point(-4.0, -4.0)

    @Test
    fun testCreateCircle() {
        var circle = Circle(listOf(pointZero), listOf(2.0))
        assertEquals(pointZero, circle.points[0])

        circle = Circle(listOf(pointOne), listOf(1.0))
        assertEquals(pointOne, circle.points[0])

        circle = Circle(listOf(pointTwo), listOf(2.0))
        assertEquals(pointTwo, circle.points[0])
    }

    @Test
    fun testNegativeRadii() {
        var circle = Circle(listOf(pointZero), listOf(-2.0))
        val block : () -> Unit = { Circle(listOf(pointZero), listOf(-2.0)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testCreateBadCircle() {
        val block : () -> Unit = { Circle(listOf(pointZero, pointOne), listOf(2.0)) }
        assertFailsWith<IllegalArgumentException> { block() }

        val block2 : () -> Unit = { Circle(listOf(pointZero), listOf(2.0, 3.0)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testGetCircleArea() {
        var circle = Circle(listOf(pointZero), listOf(2.0))
        assertEquals(PI * 2.0 * 2.0, circle.getArea())

        circle = Circle(listOf(pointZero), listOf(0.1))
        assertEquals(PI * 0.1 * 0.1, circle.getArea())

        circle = Circle(listOf(pointZero), listOf(40.0))
        assertEquals(PI * 40.0 * 40.0, circle.getArea())
    }

    @Test
    fun testMoveCircle() {
        pointZero = Point(0.0, 0.0)
        var circle = Circle(listOf(pointZero), listOf(2.0))
        circle.move(listOf(2.0, 1.0))
        assertEquals(2.0, circle.points[0].x)
        assertEquals(1.0, circle.points[0].y)

        circle = Circle(listOf(pointZero), listOf(2.0))
        circle.move(listOf(-2.0, 1.0))
        assertEquals(0.0, circle.points[0].x)
        assertEquals(2.0, circle.points[0].y)

        circle = Circle(listOf(pointZero), listOf(2.0))
        circle.move(listOf(-2.0, -1.0))
        assertEquals(-2.0, circle.points[0].x)
        assertEquals(1.0, circle.points[0].y)
    }
}