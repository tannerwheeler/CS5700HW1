package org.example

abstract class OutOfRoundShape(
    _points : List<Point>
) : Shape(_points) {

    abstract fun move(newPosition : List<List<Double>>)
}