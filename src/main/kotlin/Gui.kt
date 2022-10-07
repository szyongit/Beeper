import java.awt.Color
import java.awt.Dimension
import java.awt.Point
import java.awt.event.*
import javax.swing.JButton
import javax.swing.JFrame

private lateinit var frame: JFrame
private lateinit var button: JButton

fun loadGui() {
    frame = JFrame("Beeper!")
    frame.size = Dimension(320, 300)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE;


    var screenSize = getToolkit().screenSize;
    frame.location = Point(screenSize.width / 2 - frame.width / 2, screenSize.height / 2 - frame.height / 2)

    button()
    frame.add(button)

    frame.addComponentListener(object : ComponentAdapter() {
        override fun componentResized(e: ComponentEvent?) {
            resizeButton(frame.width, frame.height)
        }
    })

    frame.isVisible = true;
}

private fun button() {
    button = JButton("Beep!")
    button.background = Color.WHITE
    button.isFocusPainted = false

    button.addActionListener { getToolkit().beep() }
}

private fun resizeButton(width:Int, height:Int) {
    if(button == null) return
    button.size = Dimension(width, height)
    button.font = button.font.deriveFont(height.toFloat() / 10)
}