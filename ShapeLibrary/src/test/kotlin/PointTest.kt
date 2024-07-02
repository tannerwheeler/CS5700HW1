import org.example.Point
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals

class PointTest {
    var point = Point(1.0, 2.0)
    var point2 = Point(2.0, -3.0)
    var point3 = Point(-2.0, 3.0)
    var point4 = Point(-2.0, -3.0)

    @Test
    fun testCreatePoint() {
        assertEquals(1.0, point.x)
        assertEquals(2.0, point.y)

        assertEquals(2.0, point2.x)
        assertEquals(-3.0, point2.y)

        assertEquals(-2.0, point3.x)
        assertEquals(3.0, point3.y)

        assertEquals(-2.0, point4.x)
        assertEquals(-3.0, point4.y)
    }

    @Test
    fun testShiftPoint() {
        point.shift(2.0, 4.0)
        assertEquals(3.0, point.x)
        assertEquals(6.0, point.y)

        point2.shift(2.0, 4.0)
        assertEquals(4.0, point2.x)
        assertEquals(1.0, point2.y)
    }

    @Test
    fun testPointEquals() {
        assertEquals(Point(1.0, 2.0), point)
    }

    @Test
    fun testPointCopy() {
        var tempPoint = point.clone()
        tempPoint.shift(2.0, 4.0)
        assertNotEquals(tempPoint.x, point.x)
        assertNotEquals(tempPoint.y, point.y)
    }
}