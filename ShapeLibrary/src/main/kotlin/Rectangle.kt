package org.example

import kotlin.math.abs

open class Rectangle(
    _points: List<Point>
) : OutOfRoundShape(_points) {
    override val numberOfPoints = 2

    init {
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

    override fun move(newPosition : List<List<Double>>) {
        if (newPosition.size == this.numberOfPoints) {
            for (i in newPosition.indices) {
                val deltaX = newPosition[i][0] - points[i].x
                val deltaY = newPosition[i][1] - points[i].y
                points[i].shift(deltaX, deltaY)
            }
        }
    }
}