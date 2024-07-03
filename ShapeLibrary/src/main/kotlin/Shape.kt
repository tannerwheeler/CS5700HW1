package org.example

abstract class Shape(
    _points : List<Point>
) {
    abstract val numberOfPoints : Int

    var points : List<Point> = _points
        protected set(value) {
            field = value
        }

    abstract fun getArea() : Double

    fun move(deltaShift : List<Double>) {
        for (i in this.points.indices) {
            points[i].shift(deltaShift[0], deltaShift[1])
        }
    }
}