import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main program = new Main();
        int size = 3;
        program.gauss(size);
    }
    void gauss(int size){
        double[][] valueArray = matrixCreator(size);
        double[] freeArray = freeCreator(size);
        martixAndFreeSout(valueArray, freeArray);
        valueArray = elimination(valueArray);
        martixAndFreeSout(valueArray, freeArray);
    }

    double[][] elimination(double[][] valueArray){
        for(int x = 0; x < valueArray.length - 1; x++){
            for(int i = x + 1; i < valueArray.length; i++){
                double temp = valueArray[i][x]/valueArray[x][x];
                for(int j = x; j < valueArray.length; j++){
                    valueArray[i][j] = valueArray[i][j] - (valueArray[x][j] * temp);
                }
            }
        }
        return valueArray;
    }

    double[][] matrixCreator(int size){
        double[][] valueArray = new double[size][size];
        Random rand = new Random();
        for(int i=0; i<valueArray.length; i++){
            for(int j=0; j<valueArray[0].length; j++){
                valueArray[i][j] = Double.valueOf(rand.nextInt(6))+1;
            }
        }
        return valueArray;
    }
    double[] freeCreator(int size){
        double[] freeArray = new double[size];
        Random rand = new Random();
        for(int i = 0; i<size; i++){
            freeArray[i] = Double.valueOf(rand.nextInt(6))+1;
        }
        return freeArray;
    }
    void martixAndFreeSout(double[][] valueArray, double freeArray[]){
        for(int i=0; i<valueArray.length; i++){
            for(int j=0; j<valueArray[0].length; j++){
                if(valueArray[i][j]<0) System.out.print("[" + valueArray[i][j] + "] ");
                else System.out.print(" [" + valueArray[i][j] + "] ");
            }
            System.out.print("|| [" + Math.round() + "]");
            System.out.println();
        }
        System.out.println();
    }
}