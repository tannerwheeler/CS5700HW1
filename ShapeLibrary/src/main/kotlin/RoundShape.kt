package org.example

abstract class RoundShape(
    _points : ArrayList<Point>,
    _radii : ArrayList<Line>
) : Shape(_points) {
    override val numberOfPoints = 1
    abstract val numberOfRadii : Int

    var radii : ArrayList<Line> = _radii
        protected set(value) {
            field = if(this.checkNumberOfRadii() && this.checkRadii(value, this.points[0])) value else throw
            IllegalArgumentException("Incorrect Number of Radii: " +
                    "${this.javaClass} can on have ${this.numberOfRadii} radii")
        }

    fun checkNumberOfRadii(): Boolean {
        return this.points.size == this.numberOfPoints &&
                this.radii.size == this.numberOfRadii
    }

    fun checkRadii(radii : ArrayList<Line>, center : Point) : Boolean {
        var trueCount = 0
        for (line in radii) {
            if (line.startPoint == center && line.endPoint != center) {
                trueCount += 1
            }
        }
        return trueCount == this.numberOfRadii
    }

    fun move(
        newPointPosition : ArrayList<ArrayList<Double>>,
        newRadiiLengths : ArrayList<Line>
    ) {
        if (newPointPosition.size == this.numberOfPoints && newRadiiLengths.size == this.numberOfRadii) {
            val deltaX = newPointPosition[0][0] - points[0].x
            val deltaY = newPointPosition[0][1] - points[0].y
            points[0].shift(deltaX, deltaY)

            if (checkRadii(newRadiiLengths, this.points[0])) {
                radii = newRadiiLengths
            }
        }
    }
}