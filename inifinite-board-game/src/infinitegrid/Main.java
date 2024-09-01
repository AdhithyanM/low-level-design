package infinitegrid;

public class Main {
    public static void main(String[] args) {
        InfiniteGrid grid = new InfiniteGrid(3);

        // rows check
        System.out.println(grid.drop(0, Color.A ));
        System.out.println(grid.drop(1, Color.A ));
        System.out.println(grid.drop(4, Color.A ));
        System.out.println(grid.drop(3, Color.A ));
        System.out.println(grid.drop(2, Color.A ));
//        System.out.println(grid.drop(8, infinitegrid.Color.A ));

        // col check
//        System.out.println(grid.drop(0, infinitegrid.Color.A ));
//        System.out.println(grid.drop(0, infinitegrid.Color.A ));

    }
}
