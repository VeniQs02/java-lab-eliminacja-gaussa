import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GaussArray gausik = new GaussArray(3);
        System.out.println(gausik);
        System.out.println(gausik.solve());
    }
}
class GaussArray {
    int size;
    double[][] valueArray;
    double[] freeArray;

    public GaussArray(int size){
        this.size = size;
        this.valueArray = new double[size][size];
        this.freeArray = new double[size];
        matrixCreator(size);
        freeCreator(size);
    }
    void matrixCreator(int size){
        Random rand = new Random();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                valueArray[i][j] = (double) rand.nextInt(6) +1;
            }
        }
    }
    void freeCreator(int size){
        Random rand = new Random();
        for(int i = 0; i<size; i++){
            freeArray[i] = (double) rand.nextInt(6) +1;
        }
    }
    void elimination(){
        for(int x = 0; x < valueArray.length - 1; x++){
            for(int i = x + 1; i < valueArray.length; i++){
                double temp = valueArray[i][x]/valueArray[x][x];
                freeArray[i] -= freeArray[x]*temp;
                for(int j = x; j < valueArray.length; j++){
                    valueArray[i][j] -= (valueArray[x][j] * temp);
                }
            }
        }
    }
    String solve(){
        elimination();
        double[] result = new double[size];
        StringBuilder fin = new StringBuilder();
        for(int i = valueArray.length -1; i > -1; i--){
            for (int j = valueArray.length - 1; j >  i ;j--){ // for od odejmownia
                freeArray[i] = freeArray[i] -  valueArray[i][j]*result[j]  ;
            }
            result[i] = freeArray[i]/valueArray[i][i];
            fin.append(Math.round(result[i] * 1000.0) / 1000.0).append(" ");
        }
        return fin.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valueArray.length; i++) {
            for (int j = 0; j < valueArray[0].length; j++) {
                double valueValue = Math.round(valueArray[i][j] * 100.0) / 100.0;
                if (valueArray[i][j] < 0) {
                    sb.append("[").append(valueValue).append("] ");
                } else {
                    sb.append(" [").append(valueValue).append("] ");
                }
            }
            double freeValue = Math.round(freeArray[i] * 100.0) / 100.0;
            sb.append("|| [").append(freeValue).append("]\n");
        }
        return sb.toString();
    }
}
