package org.example

import kotlin.math.PI
import kotlin.math.sqrt

class Ellipse(
    _points : List<Point>,
    _radii : List<Double>
) : RoundShape(_points, _radii) {
    override val numberOfPoints = 1
    override val numberOfRadii = 2

    init {
        require(_points.size == 1) {
            "The points array must have 1 points"
        }
        require(_radii.size == 2) {
            "The points array must have 2 radii"
        }
        require(this.getArea() > 0.0) {
            "$javaClass must have area greater than 0.0"
        }
        _radii.forEach {
            require(it > 0.0) {
                "RoundShapes cannot accept negative radii."
            }
        }
    }

    override fun getArea(): Double {
        // A = PI * a * b
        // See https://www.geeksforgeeks.org/how-to-find-the-equation-of-an-ellipse-given-the-center-and-two-points/
        // for the equation of (a) and (b)
//        val p = this.radii[0].endPoint.x
//        val q = this.radii[0].endPoint.y
//        val h = this.points[0].x
//        val k = this.points[0].y
//        val m = this.radii[1].endPoint.x
//        val n = this.radii[1].endPoint.y
//        val a = sqrt((((p-h)*(p-h) * (n-q) * (n + q - (2*k)))/((p-m) * (p+m-(2*k)))) + ((q-k)*(q-k))) *
//                sqrt(((p-m)*(p+m-(2*h)))/((n-q)*(n+q-(2*k))))
//        val b = sqrt(((((p-h)*(p-h)) * (n+q-(2*k)))/((p-m) * (p+m-(2*h)))) + ((q-k)*(q-k)))
        return PI * this.radii[0] * this.radii[1]
    }
}