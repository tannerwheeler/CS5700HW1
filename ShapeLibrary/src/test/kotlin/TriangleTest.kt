import org.example.Point
import org.example.Square
import org.example.Triangle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class TriangleTest {
    var point = Point(0.0, 0.0)
    var point2 = Point(3.0, 4.0)
    var point3 = Point(6.0, 0.0)
    var point4 = Point(3.0, -4.0)
    var point5 = Point(3.0, 0.0)

    @Test
    fun testCreateTriangle() {
        val triangle = Triangle(listOf(point, point2, point3))
        assertEquals(0.0, triangle.points[0].x)
        assertEquals(0.0, triangle.points[0].y)
        assertEquals(3.0, triangle.points[1].x)
        assertEquals(4.0, triangle.points[1].y)
        assertEquals(6.0, triangle.points[2].x)
        assertEquals(0.0, triangle.points[2].y)

        val triangle2 = Triangle(listOf(point, point4, point3))
        assertEquals(0.0, triangle2.points[0].x)
        assertEquals(0.0, triangle2.points[0].y)
        assertEquals(3.0, triangle2.points[1].x)
        assertEquals(-4.0, triangle2.points[1].y)
        assertEquals(6.0, triangle2.points[2].x)
        assertEquals(0.0, triangle2.points[2].y)
    }

    @Test
    fun testCreateBadTriangle() {
        val block : () -> Unit = { Triangle(listOf(point, point.clone(), point2)) }
        assertFailsWith<IllegalArgumentException> { block() }

        val block2 : () -> Unit = { Triangle(listOf(point, point3, point4, point2)) }
        assertFailsWith<IllegalArgumentException> { block() }

        val block3 : () -> Unit = { Triangle(listOf(point, point2)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testTrianglePointsInALine() {
        val block : () -> Unit = { Triangle(listOf(point, point5, point3)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testGetTriangleArea() {
        val triangle = Triangle(listOf(point, point2, point3))
        assertEquals(12.0, triangle.getArea())
        triangle.move(listOf(2.0, 4.0))
        assertEquals(12.0, triangle.getArea())

        point = Point(0.0, 0.0)
        point3 = Point(6.0, 0.0)
        point4 = Point(3.0, -4.0)

        val triangle2 = Triangle(listOf(point, point4, point3))
        assertEquals(12.0, triangle2.getArea())
    }

    @Test
    fun testMoveTriangle() {
        val triangle = Triangle(listOf(point, point2, point3))
        triangle.move(listOf(2.0, 4.0))
        assertEquals(2.0, triangle.points[0].x)
        assertEquals(4.0, triangle.points[0].y)
        assertEquals(5.0, triangle.points[1].x)
        assertEquals(8.0, triangle.points[1].y)
        assertEquals(8.0, triangle.points[2].x)
        assertEquals(4.0, triangle.points[2].y)

        triangle.move(listOf(0.0, -8.0))
        assertEquals(2.0, triangle.points[0].x)
        assertEquals(-4.0, triangle.points[0].y)
        assertEquals(5.0, triangle.points[1].x)
        assertEquals(0.0, triangle.points[1].y)
        assertEquals(8.0, triangle.points[2].x)
        assertEquals(-4.0, triangle.points[2].y)

        point = Point(0.0, 0.0)
        point3 = Point(6.0, 0.0)
        point4 = Point(3.0, -4.0)

        val triangle2 = Triangle(listOf(point, point4, point3))
        triangle2.move(listOf(2.0, 4.0))
        assertEquals(2.0, triangle2.points[0].x)
        assertEquals(4.0, triangle2.points[0].y)
        assertEquals(5.0, triangle2.points[1].x)
        assertEquals(0.0, triangle2.points[1].y)
        assertEquals(8.0, triangle2.points[2].x)
        assertEquals(4.0, triangle2.points[2].y)
    }
}