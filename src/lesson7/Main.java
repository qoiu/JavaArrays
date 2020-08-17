package lesson7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (random.nextBoolean()) {
                    graph.addEdge(i, k);
                }
            }
        }
        System.out.println(graph.toString());

//        System.out.println(graph.getAdjList(1));
//
//        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2 );
//        System.out.println(dfp.hasPathTo(0));
//        System.out.println(dfp.pathTo(0));
//        System.out.println(dfp.hasPathTo(3));


        BreadthFirstPath bfp = new BreadthFirstPath(graph, 5);
        System.out.println(bfp.hasPathTo(0));
        System.out.println(bfp.pathTo(0));
        System.out.println(bfp.hasPathTo(3));

        Graph graph2 = new Graph(10);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(5, 6);
        System.out.println(graph2);

        BreadthFirstPath bfp2 = new BreadthFirstPath(graph2, 1);
        bfp.marked
        System.out.println(bfp2.hasPathTo(6));
        System.out.println(bfp2.pathTo(6));
        System.out.println(bfp2.hasPathTo(3));

}
}
