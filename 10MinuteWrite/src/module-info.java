module application {
	exports application;
	exports application.Model;
	exports application.Controller;
	exports application.View;

	requires java.desktop;
	requires transitive javafx.base;
	requires transitive javafx.fxml;
	requires transitive javafx.graphics;
	requires transitive javafx.media;
	requires javafx.swing;
	requires jdk.compiler;
	requires transitive javafx.controls;
}