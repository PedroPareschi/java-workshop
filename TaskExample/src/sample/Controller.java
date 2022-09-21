package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {


    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;

    public void initialize(){
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//
//                String[] names = {"Pedro Pareschi",
//                        "Lucas Cardoso",
//                        "Daniel Ferreira",
//                        "Afrodite Pareschi",
//                        "Luan Lopes",
//                        "Catherine Lauro"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
//
//                for(int i = 0; i<6; i++){
//                    employees.add(names[i]);
//                    updateMessage("Added " + names[i] + " to the list");
//                    updateProgress(i+1, 6);
//                    Thread.sleep(200);
//                }
//                return employees;
//            }
//        }

        service = new EmployeeService();
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());

//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(true);
//                progressLabel.setVisible(true);
//            }
//        });
//
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(false);
//                progressLabel.setVisible(false);
//            }
//        });

//        progressLabel.setVisible(false);
//        progressBar.setVisible(false);

        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());
    }

    @FXML
    public void buttonPressed(){
        if(service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        } else if(service.getState() == Worker.State.READY) {
            service.start();
        }
    }
}
