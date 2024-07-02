package org.example

import kotlin.math.sqrt

class Line(
    var startPoint : Point,
    var endPoint : Point
) {
    init {
        require(getLength() > 0) {"Length must be greater than zero"}
    }

    fun getSlope() : Double {
        val numerator = this.endPoint.y - this.startPoint.y
        val denominator = this.endPoint.x - this.startPoint.x
        return numerator / denominator
    }

    fun getLength() : Double {
        val deltaX = this.endPoint.x - this.startPoint.x
        val deltaY = this.endPoint.y - this.startPoint.y
        return sqrt((deltaX * deltaX) + (deltaY * deltaY))
    }

    fun move(startPoint : Point, endPoint : Point) {
        require(!(startPoint.x == endPoint.x && startPoint.y == endPoint.y)) {
            "Line must have a length greater than zero"
        }
        this.startPoint = startPoint
        this.endPoint = endPoint
    }
}