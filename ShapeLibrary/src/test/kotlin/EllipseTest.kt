import org.example.Ellipse
import org.example.Point
import org.example.Square
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.math.PI

class EllipseTest {
    var pointZero = Point(0.0, 0.0)
    var pointOne = Point(0.0, 1.0)
    var pointTwo = Point(-4.0, -4.0)

    @Test
    fun testCreateEllipse() {
        var ellipse = Ellipse(listOf(pointZero), listOf(2.0, 1.0))
        assertEquals(pointZero, ellipse.points[0])

        ellipse = Ellipse(listOf(pointOne), listOf(1.0, 2.0))
        assertEquals(pointOne, ellipse.points[0])

        ellipse = Ellipse(listOf(pointTwo), listOf(2.0, 1.0))
        assertEquals(pointTwo, ellipse.points[0])
    }

    @Test
    fun testNegativeRadii() {
        val block : () -> Unit = { Ellipse(listOf(pointZero), listOf(-2.0, 1.0)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testCreateBadEllipse() {
        val block : () -> Unit = { Ellipse(listOf(pointZero, pointOne), listOf(2.0, 1.0)) }
        assertFailsWith<IllegalArgumentException> { block() }

        val block2 : () -> Unit = { Ellipse(listOf(pointZero), listOf(2.0, 1.0, 3.0)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testGetEllipseArea() {
        var ellipse = Ellipse(listOf(pointZero), listOf(2.0, 1.0))
        assertEquals(PI * 2.0 * 1.0, ellipse.getArea())

        ellipse = Ellipse(listOf(pointZero), listOf(0.1, 0.004))
        assertEquals(PI * 0.1 * 0.004, ellipse.getArea())

        ellipse = Ellipse(listOf(pointZero), listOf(0.1, 40.0))
        assertEquals(PI * 0.1 * 40.0, ellipse.getArea())
    }

    @Test
    fun testMoveEllipse() {
        var ellipse = Ellipse(listOf(pointZero), listOf(2.0, 1.0))
        ellipse.move(listOf(2.0, 1.0))
        assertEquals(2.0, ellipse.points[0].x)
        assertEquals(1.0, ellipse.points[0].y)

        pointZero = Point(0.0, 0.0)

        ellipse = Ellipse(listOf(pointZero), listOf(2.0, 1.0))
        ellipse.move(listOf(-2.0, 1.0))
        assertEquals(-2.0, ellipse.points[0].x)
        assertEquals(1.0, ellipse.points[0].y)

        pointZero = Point(0.0, 0.0)

        ellipse = Ellipse(listOf(pointZero), listOf(2.0, 1.0))
        ellipse.move(listOf(-2.0, -1.0))
        assertEquals(-2.0, ellipse.points[0].x)
        assertEquals(-1.0, ellipse.points[0].y)
    }
}