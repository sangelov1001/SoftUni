package abstractionExercises;

public class Field {
    // тук си генерираме бойното поле
    // това отговаря за матрицата
    private int[][] matrix;

    // с този конструктор тук си правим подсигуряване да не подаваме всеки път стойност 0.
    // това как я четем
    public Field(int rows, int cols) {
        this.matrix = new int[rows][cols];
        this.fillValues(0);
    }

    // това как я пълним
    public Field(int row, int col, int beginValue) {
        this.matrix = new int[row][col];
        this.fillValues(beginValue);
    }

    private void fillValues(int beginValue) {
        for (int row = 0; row < this.matrix.length; row++) {
            for (int col = 0; col < this.matrix[row].length; col++) {
                    this.matrix[row][col] = beginValue++;
            }
        }
    }
}
