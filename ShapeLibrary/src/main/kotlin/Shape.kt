package org.example

abstract class Shape(
    _points : List<Point>
) {
    abstract val numberOfPoints : Int

    var points : List<Point> = _points
        protected set(value) {
            require(value.size == numberOfPoints) {
                "$javaClass should have ${this.numberOfPoints} points"
            }
            field = value
        }

    fun checkNumberOfPoints(): Boolean {
        return this.points.size == this.numberOfPoints
    }

    abstract fun getArea() : Double
}