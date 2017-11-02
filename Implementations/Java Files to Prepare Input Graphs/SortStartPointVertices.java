///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This program takes a graph file and sort it according to start-point vertices increasingly. It means first all edges from vertex zero is written, then all edges from vertex one and so on.
//
// Please fill the parameters according to the input graph file (e.g., address of input/output files, NumberofNodes, NumberofEdges).
//
// Created By Mohsen Safari.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SortStartPointVertices {

	public static void main(String[] args) {
		
		int NumberofNodes = 3598623; // Number of nodes
		int NumberofEdges = 8778114; // Number of edges
		FileReader filereader = null; 
		FileWriter filewriter = null;
		int[] node1 = new int[NumberofEdges]; 
		int[] node2 = new int[NumberofEdges];
		int[] node3 = new int[NumberofEdges];
		
		try {
			filereader = new FileReader("/home/mohsen/Eastern.txt"); // Input graph file
			} 
		catch (FileNotFoundException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
		
		try {
			filewriter = new FileWriter("/home/mohsen/Eastern-in-sequence.txt"); // Output graph file sorted according to start-point vertices
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader bufferreader; 
		BufferedWriter bufferwriter = new BufferedWriter(filewriter);
		String strLine;
		int k=0;

			try {
				filereader = new FileReader("/home/mohsen/Eastern.txt"); // Input graph file
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			bufferreader = new BufferedReader(filereader);
			try {
				strLine = bufferreader.readLine();
				strLine = bufferreader.readLine();
				while ((strLine = bufferreader.readLine()) != null )   
				{
				   String[] tokens = strLine.split(" ");
				    node1[k] = Integer.parseInt(tokens[0]);
				    node2[k] = Integer.parseInt(tokens[1]);
				    node3[k] = Integer.parseInt(tokens[2]);
				    k++;
				}
				
				} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			bufferwriter.write(NumberofNodes + "\n"); 
			bufferwriter.write(NumberofEdges + "\n"); 
			for(int i=0; i<NumberofNodes; i++){ 
				for(int d=0; d<NumberofEdges; d++) 
				{

					if (i == node1[d])
						bufferwriter.write(node1[d] + " " + node2[d] + " " + node3[d] + "\n");
				}
			}
		
			bufferwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
