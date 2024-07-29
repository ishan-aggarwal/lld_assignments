package example_sorting_interface.o1;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Builder
public class MyCar implements ICar {
    int Price;
    int Speed;

    @Override
    public int compareTo(MyCar o) {
        return this.Price - o.Price;
    }




    public static void main(String[] args) {
        List<MyCar> carList = new ArrayList<>();

        carList.add(new MyCar(10000, 1));
        carList.add(new MyCar(20000, 2));
        carList.add(new MyCar(12000, 3));

        Collections.sort(carList);
    }
}
