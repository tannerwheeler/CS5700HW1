package org.example

import kotlin.math.abs

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
}