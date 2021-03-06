package lichen;

public class ImmuneCell extends HealthyCell {
    private int t = 4;//кол-во ед. времени.

    ImmuneCell(int i, int j) {
        super(i, j);
        isHealthy = false;
    }

    public char getCellState() { return 'O'; }//возвращаем состояние для отображения на участке кожи иммуных клеток

    public HealthyCell update(Skin skin) { // Отсчитываем 4 ед. времени, когда время жизни истекает - заменяем на здоровую
        if (t-- != 0) return this;
        return new HealthyCell(i, j);
    }
}
/*                                           Условие задачи
Промоделирйте процесс распространения инфекции стригущего лишая по участку кожи 20х20 клеток. Предполагается, что изначально заражены клетки с координатами (7, 4), (6, 15), (17, 10).
В каждый интервал времени Пораженная инфекцией клетка может с вероятностью 0.5 заразить любую из соседних здоровых клеток (но только одну).
По прошествии 6 ед времени зараженная клетка становится невосприимчива к инфекции, возникший иммунитет действует в течение 4 ед времени,
а затем клетка становится здоровой. В ходе моделирования описанного процесса обеспечить вывод на печать текущего состояния моделируемого участка кожи в каждом интервале времени,
отмечая зараженные, здоровые, невосприимчивые к инфекции клетки.
 */
