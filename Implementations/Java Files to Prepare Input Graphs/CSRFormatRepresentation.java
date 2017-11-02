///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This program takes the output file from "SortStartPointVertices.java" and change it into CSR representation. Therefore, Please first use "SortStartPointVertices.java" to get the output file and then use the file as input for this program. The "Vertex-Based.cu" file needs the output of this program as input graph file.
//
// Please fill the parameters according to the input graph file (e.g., address of input/output files, NumberofNodes, NumberofEdges).
//
// Created by Mohsen Safari.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CSRFormatRepresentation {

	public static void main(String[] args) {
		
		int NumberofNodes = 6262104; // Number of nodes
		int NumberofEdges = 15248146; // Number of edges
		FileReader filereader = null;
		FileWriter filewriter = null;
		int array[] = new int[NumberofNodes];
		int nodearray[] = new int[NumberofNodes];
		int edgearray[][] = new int [NumberofEdges][2];
		for(int i=0; i<array.length; i++)
		{
			array[i] = 0;
			nodearray[i] = 0;
		}
		
		try {
			filereader = new FileReader("/home/mohsen/Western-in-sequence.txt"); // Input graph file
			} 
		catch (FileNotFoundException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
		
		try {
			filewriter = new FileWriter("/home/mohsen/Western-CSR.txt"); // Output graph file according to CSR representation
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader bufferreader = new BufferedReader(filereader);
		BufferedWriter bufferwriter = new BufferedWriter(filewriter);
		String strLine;
		
		try {
			bufferwriter.write("NumberofNodes" + "\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int t=0, k=0;
		try {

			strLine = bufferreader.readLine();
			strLine = bufferreader.readLine();
			while ((strLine = bufferreader.readLine()) != null )   
			{
				   String[] tokens = strLine.split(" ");
				   int node1 = Integer.parseInt(tokens[0]);
				   array[node1]++;
				   edgearray[t][k] = Integer.parseInt(tokens[1]);
				   k++;
				   edgearray[t][k] = Integer.parseInt(tokens[2]);
				   k=0;
				   t++;
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0; i<NumberofNodes; i++)
			for(int j=0; j<i; j++)
				nodearray[i] += array[j];
		
		
			try {
				for(int i=0; i<NumberofNodes; i++)
					bufferwriter.write(nodearray[i] + " " + array[i] + "\n");
				bufferwriter.write("0"+ "\n");
				bufferwriter.write("NumberofEdges"+ "\n");
				for(int i=0; i<NumberofEdges; i++)  
				{
					   bufferwriter.write(edgearray[i][0] + " " + edgearray[i][1] + "\n");
				}
				
			bufferwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
