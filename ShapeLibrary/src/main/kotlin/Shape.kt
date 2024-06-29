package org.example

abstract class Shape(
    _points : ArrayList<Point>
) {
    abstract val numberOfPoints : Int

    var points : ArrayList<Point> = _points
        protected set(value) {
            field = if(this.checkNumberOfPoints()) value else throw
                IllegalArgumentException("Incorrect Number of Points: " +
                        "${this.javaClass} can on have ${this.numberOfPoints} points")
        }

    fun checkNumberOfPoints(): Boolean {
        return this.points.size == this.numberOfPoints
    }

    abstract fun getArea() : Double
}