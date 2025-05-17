package projetosudoku;

import javafx.application.Application;
import javafx.stage.Stage;
import projetosudoku.buildlogic.SudokuBuildLogic;
import projetosudoku.userinterface.IUserInterfaceContract;
import projetosudoku.userinterface.UserInterfaceImpl;

import java.io.IOException;

public class ProjetoSudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start (Stage primaryStage) throws IOException{
        uiImpl = new UserInterfaceImpl(primaryStage);
        try{
            SudokuBuildLogic.build(uiImpl);
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }



}
