package com.patres.automation.action.mouse.point

import com.patres.automation.point.ImageToPointConverter
import com.patres.automation.point.Point

class ImagePointDetector(
        val templateByteArray: ByteArray,
        val threshold: Double
) : PointDetector {

    override fun calculatePoint() = loadPoint()

    private fun loadPoint(): Point? {
        val thresholdMatch = threshold / 100.0
        val imageToPointConverter = ImageToPointConverter(templateByteArray, thresholdMatch)
        return imageToPointConverter.calculatePointByTemplateMatchAndLogTime()
    }

    override fun toString() = "ImagePointDetector(templateByteArray=${templateByteArray}, threshold=$threshold)"

}