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
        double[][] wholeArray = elimination(valueArray, freeArray);
        wholeSout(wholeArray);
    }

    double[][] elimination(double[][] valueArray, double[] freeArray){
        for(int x = 0; x < valueArray.length - 1; x++){
            for(int i = x + 1; i < valueArray.length; i++){
                double temp = valueArray[i][x]/valueArray[x][x];
                freeArray[i] -= freeArray[x]*temp;
                for(int j = x; j < valueArray.length; j++){
                    valueArray[i][j] -= (valueArray[x][j] * temp);
                }
            }
        }
        double[][] tempArray = new double[valueArray.length][valueArray[0].length +1];
        for(int i = 0 ; i< valueArray.length + 1; i++){
            for(int j = 0; j< valueArray[0].length; j++){
                if(j == valueArray.length){
                    tempArray[i][j] = freeArray[i];
                }else{
                    tempArray[i][j] = valueArray[i][j];
                }
            }
        }
        return tempArray;
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
                double valueValue = Math.round(valueArray[i][j]*100.0)/100.0;
                if(valueArray[i][j]<0) System.out.print("[" + valueValue + "] ");
                else System.out.print(" [" + valueValue + "] ");
            }
            double freeValue = Math.round(freeArray[i]*100.0)/100.0;
            System.out.print("|| [" + freeValue  + "]");
            System.out.println();
        }
        System.out.println();
    }
    void wholeSout(double[][] wholeArray){
        for(int i=0; i<wholeArray.length; i++){
            for(int j=0; j<wholeArray[0].length; j++){
                double valueValue = Math.round(wholeArray[i][j]*100.0)/100.0;
                if(i == wholeArray.length) System.out.print("|| ");
                if(wholeArray[i][j]<0) System.out.print("[" + valueValue + "] ");
                else System.out.print(" [" + valueValue + "] ");

            }
            System.out.println();
        }
        System.out.println();
    }
}


