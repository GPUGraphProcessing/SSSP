////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This program generates a query file for each graph. The "Vertex-Based.cu" needs a query file for each graph , because the CUDA file runs the algorithm for a fix number and take an average over time. Thus, in each iteration, a random source of the graph is chosen. This Java program creates that file for choosing random sources.  
//
// Please fill the parameters according to the input graph file (e.g., address of output file, NumberofQueries, NumberofNodes).
//
// Created by Mohsen Safari.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class QueryGenerator {

	public static void main(String[] args) {

		int NumberofQueries = 10000; // Number of query sources
		int NumberofNodes = 321270; // Number of nodes		
		FileWriter filewriter = null;
		Random rn = new Random();
		
		try {
			filewriter = new FileWriter("/home/mohsen/Java-Preprocessing-Programs/SanFranciscoQueries.txt"); // Output file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter bufferwriter = new BufferedWriter(filewriter);
		
		try {
			
			for (int i=0; i<NumberofQueries; i++) 
				bufferwriter.write(rn.nextInt(NumberofNodes) + " " + rn.nextInt(NumberofNodes) + "\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			bufferwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
