package br.com.pedropareschi.todoList;

import br.com.pedropareschi.todoList.datamodel.TodoData;
import br.com.pedropareschi.todoList.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    public TodoItem processResults(TodoItem oldTodoItem){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().editTodoItem(oldTodoItem, newItem);
        return newItem;
    }

    public void showPreviousDetails(TodoItem item){
        shortDescriptionField.setText(item.getShortDescription());
        detailsArea.setText(item.getDetails());
        deadlinePicker.setValue(item.getDeadLine());
    }
}
