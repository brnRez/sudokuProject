package projetosudoku.userinterface;

import projetosudoku.domain.SudokuGame;

public interface IUserInterfaceContract {
    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }


    interface View{
        void setListener(IUserInterfaceContract.EventListener l);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
