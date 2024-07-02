package org.example

class Square(
    _points : List<Point>
) : Rectangle(_points) {
    override val numberOfPoints = 2

    override fun checkWidthAndHeight(): Boolean {
        return getHeight() == getWidth() && getHeight() > 0.0 && getHeight() > 0.0
    }
}