package org.example

import kotlin.math.abs

open class Rectangle(
    _points: List<Point>
) : Shape(_points) {
    override val numberOfPoints = 2

    init {
        require(_points.size == 2) {
            "The points array must have 2 points"
        }
        require(this.getArea() > 0.0) {
            "$javaClass must have area greater than 0.0"
        }
    }

    override fun getArea(): Double {
        return getWidth() * getHeight()
    }

    fun getWidth() : Double {
        return abs(points[0].x - points[1].x)
    }

    fun getHeight() : Double {
        return abs(points[0].y - points[1].y)
    }
}