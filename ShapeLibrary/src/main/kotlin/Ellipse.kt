package org.example

import kotlin.math.PI

class Ellipse(
    _points : ArrayList<Point>,
    _radii : ArrayList<Double>
) : RoundShape(_points, _radii) {
    override val numberOfPoints = 1
    override val numberOfRadii = 2

    override fun getArea(): Double {
        // A = PI * a * b
        return PI * this.radii[0] * this.radii[1]
    }
}