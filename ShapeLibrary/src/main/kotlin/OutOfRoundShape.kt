package org.example

abstract class OutOfRoundShape(
    _points : ArrayList<Point>
) : Shape(_points) {

    fun move(newPosition : ArrayList<ArrayList<Double>>) {
        if (newPosition.size == this.numberOfPoints) {
            for (i in newPosition.indices) {
                val deltaX = newPosition[i][0] - points[i].x
                val deltaY = newPosition[i][1] - points[i].y
                points[i].shift(deltaX, deltaY)
            }
        }
    }
}