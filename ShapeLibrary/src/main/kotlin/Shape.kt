package org.example

abstract class Shape(
    _points : List<Point>
) {
    abstract val numberOfPoints : Int

    var points : List<Point> = _points
        protected set(value) {
            field = value
        }

    init {
        require(this.checkNumberOfPoints()) {
            "$javaClass should have ${this.numberOfPoints} points"
        }
        require(this.getArea() > 0.0) {
            "$javaClass must have area greater than 0.0"
        }
    }

    fun checkNumberOfPoints(): Boolean {
        return this.points.size == this.numberOfPoints
    }

    abstract fun getArea() : Double
}