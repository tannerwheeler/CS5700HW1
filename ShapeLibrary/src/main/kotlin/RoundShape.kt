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
            value.forEach {
                require(it > 0.0) {
                    "RoundShapes cannot accept negative radii."
                }
            }
            field = value
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
}