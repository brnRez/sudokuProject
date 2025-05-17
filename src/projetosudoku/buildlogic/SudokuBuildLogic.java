package projetosudoku.buildlogic;

import projetosudoku.computationlogic.GameLogic;
import projetosudoku.domain.IStorage;
import projetosudoku.domain.SudokuGame;
import projetosudoku.persistence.LocalStorageImpl;
import projetosudoku.userinterface.IUserInterfaceContract;
import projetosudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try{
            initialState = storage.getGameData();
        }catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
