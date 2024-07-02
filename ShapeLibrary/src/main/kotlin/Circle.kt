package org.example

import kotlin.math.PI

class Circle(
    _points : List<Point>,
    _radii : List<Double>
) : RoundShape(_points, _radii) {
    override val numberOfPoints = 1
    override val numberOfRadii = 1

    init {
        require(this.getArea() > 0.0) {
            "$javaClass must have area greater than 0.0"
        }
    }

    override fun getArea(): Double {
        // A = PI * r^2
        return PI * this.radii[0] * this.radii[0]
    }
}