import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Component; 
import java.util.Scanner;



class Teapot extends Component {

    
    public static void main(String[] args) throws FileNotFoundException {

		int i = 0, j = 0;
		//deklarujemy miejsce dla punktow
		double [][] pointsBrazX = new double[32][16];
		double [][] pointsBrazY =  new double[32][16];
		double [][] pointsBrazZ =  new double[32][16];
		//wczytujemy dane z pliku
    	File pkt = new File("points.txt");
		Scanner s = new Scanner(pkt);
		for (i = 0; i < 32; i++) {
			for(j = 0; j < 16; j++){
				//dodajemy do kadego miejsca x,y,z punkt
				pointsBrazX[i][j] = Double.valueOf(s.next());
				pointsBrazY[i][j] = Double.valueOf(s.next());
				pointsBrazZ[i][j] = Double.valueOf(s.next());
			}
		}
		//tworzymy plik dla zapisywania punktow czajnika
        try {
        	PrintWriter fileout = new PrintWriter( new FileWriter("D:\\points_for_PV.txt"));
        	//obliczmy punkty czajnika
		for (int k = 0; k < pointsBrazX.length; k++){
        	for (double v=0.0; v<=1.0; v+=0.001){
        		for (double w=0.0; w<=1.0; w+=0.001) {
    		double Px= ((1-v)*(1-v)*(1-v)*pointsBrazX[k][0] + 3*v*(1-v)*(1-v)*pointsBrazX[k][1] + 3*v*v*(1-v)*pointsBrazX[k][2]+ v*v*v*pointsBrazX[k][3])*(1-w)*(1-w)*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazX[k][4] + 3*v*(1-v)*(1-v)*pointsBrazX[k][5] + 3*v*v*(1-v)*pointsBrazX[k][6]+ v*v*v*pointsBrazX[k][7])*3*w*(1-w)*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazX[k][8] + 3*v*(1-v)*(1-v)*pointsBrazX[k][9] + 3*v*v*(1-v)*pointsBrazX[k][10]+ v*v*v*pointsBrazX[k][11])*3*w*w*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazX[k][12] + 3*v*(1-v)*(1-v)*pointsBrazX[k][13] + 3*v*v*(1-v)*pointsBrazX[k][14]+ v*v*v*pointsBrazX[k][15])*w*w*w;
    		double Py= ((1-v)*(1-v)*(1-v)*pointsBrazY[k][0] + 3*v*(1-v)*(1-v)*pointsBrazY[k][1] + 3*v*v*(1-v)*pointsBrazY[k][2]+ v*v*v*pointsBrazY[k][3])*(1-w)*(1-w)*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazY[k][4] + 3*v*(1-v)*(1-v)*pointsBrazY[k][5] + 3*v*v*(1-v)*pointsBrazY[k][6]+ v*v*v*pointsBrazY[k][7])*3*w*(1-w)*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazY[k][8] + 3*v*(1-v)*(1-v)*pointsBrazY[k][9] + 3*v*v*(1-v)*pointsBrazY[k][10]+ v*v*v*pointsBrazY[k][11])*3*w*w*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazY[k][12] + 3*v*(1-v)*(1-v)*pointsBrazY[k][13] + 3*v*v*(1-v)*pointsBrazY[k][14]+ v*v*v*pointsBrazY[k][15])*w*w*w;
    		double Pz= ((1-v)*(1-v)*(1-v)*pointsBrazZ[k][0] + 3*v*(1-v)*(1-v)*pointsBrazZ[k][1] + 3*v*v*(1-v)*pointsBrazZ[k][2]+ v*v*v*pointsBrazZ[k][3])*(1-w)*(1-w)*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazZ[k][4] + 3*v*(1-v)*(1-v)*pointsBrazZ[k][5] + 3*v*v*(1-v)*pointsBrazZ[k][6]+ v*v*v*pointsBrazZ[k][7])*3*w*(1-w)*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazZ[k][8] + 3*v*(1-v)*(1-v)*pointsBrazZ[k][9] + 3*v*v*(1-v)*pointsBrazZ[k][10]+ v*v*v*pointsBrazZ[k][11])*3*w*w*(1-w)+((1-v)*(1-v)*(1-v)*pointsBrazZ[k][12] + 3*v*(1-v)*(1-v)*pointsBrazZ[k][13] + 3*v*v*(1-v)*pointsBrazZ[k][14]+ v*v*v*pointsBrazZ[k][15])*w*w*w;
    		//zapisujemy dane do pliku
    		fileout.println(Px +" " + Py + " " + Pz);
        		}
        	}
        }
		//zamykamy plik
		fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}













