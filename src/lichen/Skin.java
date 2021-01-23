package lichen;

class Skin {
    private final static int SIZE = 22;
    private HealthyCell[][] cells;
    private HealthyCell[][] cells2;

    Skin() {
        cells = new HealthyCell[SIZE][SIZE];
        cells2 = new HealthyCell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new HealthyCell(i, j);
                cells2[i][j] = new HealthyCell(i, j);
            }
        }
        lifeField(cells);
        lifeField(cells2);
    }

    private void lifeField(HealthyCell[][] arrayOfCells){
        for(int i=0;i<SIZE;i++){
            arrayOfCells[i][0]=new ImmuneCell(i,0);
            arrayOfCells[i][SIZE-1] = new ImmuneCell(i,SIZE-1);
        }
        for(int i=1;i<SIZE-1;i++){
            arrayOfCells[0][i]=new ImmuneCell(0,i);
            arrayOfCells[SIZE-1][i]=new ImmuneCell(SIZE-1,i);
        }
    }

    void update() {
        for (int i = 1; i < SIZE-1; i++) {
            for (int j = 1; j < SIZE-1; j++) cells2[i][j] = cells[i][j].update(this);
        }
        HealthyCell[][] temporary = cells;
        cells = cells2;
        cells2 = temporary;
    }
    HealthyCell[][] getCells() { return cells; }

    HealthyCell[][] getCells2() { return cells2; }

    void injectionInfectedCells() {
        cells[7][4] = new InfectedCell(7, 4);
        cells[6][15] = new InfectedCell(6, 15);
        cells[17][10] = new InfectedCell(17, 10);

        cells2[7][4] = new InfectedCell(7, 4);
        cells2[6][15] = new InfectedCell(6, 15);
        cells2[17][10] = new InfectedCell(17, 10);
    }

    void print() {
        for (int i = 1; i < SIZE-1; i++) {
            for (int j = 1; j < SIZE-1; j++) {
                System.out.print(String.format("%s\t", cells[i][j].getCellState()));
            }
            System.out.println();
        }
        System.out.println();
    }
}
 /*                                           Условие задачи
Промоделирйте процесс распространения инфекции стригущего лишая по участку кожи 20х20 клеток. Предполагается, что изначально заражены клетки с координатами (7, 4), (6, 15), (17, 10).
В каждый интервал времени Пораженная инфекцией клетка может с вероятностью 0.5 заразить любую из соседних здоровых клеток (но только одну).
По прошествии 6 ед времени зараженная клетка становится невосприимчива к инфекции, возникший иммунитет действует в течение 4 ед времени,
а затем клетка становится здоровой. В ходе моделирования описанного процесса обеспечить вывод на печать текущего состояния моделируемого участка кожи в каждом интервале времени,
отмечая зараженные, здоровые, невосприимчивые к инфекции клетки.
 */
