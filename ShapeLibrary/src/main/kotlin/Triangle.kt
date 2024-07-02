package org.example

import kotlin.math.abs

class Triangle(
    _points: List<Point>
) : OutOfRoundShape(_points) {
    override val numberOfPoints = 3

    init {
        require(this.getArea() > 0.0) {
            "$javaClass must have area greater than 0.0"
        }
    }

    override fun getArea(): Double {
        // Equation of the Area of a Triangle from 3 points
        // A = (1/2) * abs(x_1 * (y_2 - y_3) + x_2 * (y_3 - y_1) + x_3 * (y_1 - y_2))
        val portion1 = this.points[0].x * (this.points[1].y - this.points[2].y)
        val portion2 = this.points[1].x * (this.points[2].y - this.points[0].y)
        val portion3 = this.points[2].x * (this.points[0].y - this.points[1].y)
        return abs(portion1 + portion2 + portion3) / 2.0
    }
}