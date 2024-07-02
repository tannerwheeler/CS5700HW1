package org.example

import kotlin.math.abs

abstract class Rectangle(
    _points: List<Point>
) : OutOfRoundShape(_points) {
    override val numberOfPoints = 2

    override fun getArea(): Double {
        return getWidth() * getWidth()
    }

    fun getWidth() : Double {
        return abs(points[0].x - points[1].x)
    }

    fun getHeight() : Double {
        return abs(points[0].y - points[1].y)
    }

    open fun checkWidthAndHeight() : Boolean {
        return getWidth() > 0.0 && getHeight() > 0.0
    }
}