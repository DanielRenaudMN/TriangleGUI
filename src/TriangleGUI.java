import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Daniel Renaud
 *
 */

/**
 * The TriangleGUI class creates a graphical user interface where the user can
 * enter the coordinates of the three vertices that make up a triangle in the
 * xy-plane, and click the "create" button to generate an image of that
 * triangle. The user can create more than one triangle within the canvas and
 * press the "end" button to terminate the program.
 */
public class TriangleGUI extends Application implements EventHandler<ActionEvent> {
	private Button createButton = new Button("create");
	private Button endButton = new Button("end");
	private TextField fieldForX1 = new TextField();
	private TextField fieldForY1 = new TextField();
	private Text labelForPoint1 = new Text(" Point 1   ");
	private TextField fieldForX2 = new TextField();
	private TextField fieldForY2 = new TextField();
	private Text labelForPoint2 = new Text(" Point 2   ");
	private TextField fieldForX3 = new TextField();
	private TextField fieldForY3 = new TextField();
	private Text labelForPoint3 = new Text(" Point 3   ");
	private Text columnHeaderForX = new Text("x");
	private Text columnHeaderForY = new Text("y");
	private Canvas triangleCanvas = new Canvas(400, 400);
	private GraphicsContext graphicsContext = triangleCanvas.getGraphicsContext2D();

	/**
	 * The start method first assembles all the components of the program together
	 * and organizes them through the use of container classes that are part of the
	 * javafx.scene.layout package. Then it configures the primaryStage so that the
	 * GUI will launch properly when the program is run.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane gridpane = new GridPane();
		BorderPane borderpane = new BorderPane();
		gridpane.add(columnHeaderForX, 1, 1);
		gridpane.add(columnHeaderForY, 2, 1);
		gridpane.add(labelForPoint1, 0, 2);
		gridpane.add(labelForPoint2, 0, 3);
		gridpane.add(labelForPoint3, 0, 4);
		fieldForX1.setPrefWidth(200);
		fieldForY1.setPrefWidth(200);
		gridpane.add(fieldForX1, 1, 2);
		gridpane.add(fieldForY1, 2, 2);
		gridpane.add(fieldForX2, 1, 3);
		gridpane.add(fieldForY2, 2, 3);
		gridpane.add(fieldForX3, 1, 4);
		gridpane.add(fieldForY3, 2, 4);
		gridpane.add(createButton, 0, 5);
		gridpane.add(endButton, 1, 5);
		borderpane.setTop(triangleCanvas);
		borderpane.setCenter(gridpane);
		createButton.setOnAction(this);
		endButton.setOnAction(this);
		Scene scene = new Scene(borderpane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Assignment 2");
		primaryStage.show();
	}

	/**
	 * The handle method is responsible for making the buttons and fields of the GUI
	 * functional, and thus contains the code used to draw the lines of the
	 * triangle.
	 */
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == createButton) {
			Point p1 = new Point(Integer.parseInt(fieldForX1.getText()), Integer.parseInt(fieldForY1.getText()));
			Point p2 = new Point(Integer.parseInt(fieldForX2.getText()), Integer.parseInt(fieldForY2.getText()));
			Point p3 = new Point(Integer.parseInt(fieldForX3.getText()), Integer.parseInt(fieldForY3.getText()));
			graphicsContext.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			graphicsContext.strokeLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
			graphicsContext.strokeLine(p3.getX(), p3.getY(), p1.getX(), p1.getY());
		} else if (event.getSource() == endButton) {
			System.exit(0);
		}
	}

	/**
	 * In this program, main holds the command that launches the GUI.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
