package org.example

class Square(
    _points : List<Point>
) : Rectangle(_points) {
    override val numberOfPoints = 2

    init {
        require(_points.size == 2) {
            "The points array must have 2 points"
        }
        require(this.getArea() > 0.0) {
            "$javaClass must have area greater than 0.0"
        }
    }
}