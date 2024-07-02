package org.example

abstract class RoundShape(
    _points : List<Point>,
    _radii : List<Double>
) : Shape(_points) {
    override val numberOfPoints = 1
    abstract val numberOfRadii : Int

    var radii : List<Double> = _radii
        protected set(value) {
            field = value
        }

    init {
        require(this.checkNumberOfPoints()) {
            "$javaClass should have ${this.numberOfPoints} points"
        }
        require(this.checkNumberOfRadii()) {
            "$javaClass should have ${this.numberOfRadii} radius"
        }
    }

    fun checkNumberOfRadii(): Boolean {
        return this.points.size == this.numberOfPoints &&
                this.radii.size == this.numberOfRadii
    }

    fun checkRadii(radii : List<Double>) : Boolean {
        for (radius in radii) {
           if (radius <= 0.0) return false
        }
        return true
    }

    fun move(
        newPointPosition : List<List<Double>>,
        newRadiiLengths : List<Double>
    ) {
        require(newPointPosition.size == this.numberOfPoints) {
            "$javaClass must have ${this.numberOfPoints} points"
        }
        require(newRadiiLengths.size == this.numberOfRadii) {
            "$javaClass must have ${this.numberOfRadii} radii"
        }
        require(this.checkRadii(newRadiiLengths)) {
            "$javaClass must have radii greater than 0.0"
        }

        val deltaX = newPointPosition[0][0] - points[0].x
        val deltaY = newPointPosition[0][1] - points[0].y
        points[0].shift(deltaX, deltaY)

        radii = newRadiiLengths
    }
}