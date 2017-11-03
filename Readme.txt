- The CUDA implementation is in ~/Implementations/Vertex-Based Algorithm/Vertex-Based.cu

- The input graphs are in "Input Graphs" folder. The format of the files to represent graphs is:

number of nodes
number of edges
startpoint endpoint weight
    .         .       .
    .         .       .
    .         .       .

- There are some Java programs in ~/Implementations/Java Files to Prepare Input Graphs:

    - SortStartPointVertices.java: use this file first to sort the edges according to startpoint vertices increasingly.
    - CSRFormatRepresentation.java: then use this file to convert the output file of "SortStartPointVertices.java" into CSR representation. The output of this program (CSR format) is used as input for "Vertex-Based.cu".
    - QueryGenerator.java: This file is used to generate random sources and is used as input query file in "Vertex-Based.cu". 


- Please Set the addresses of the input graph and query files in "Vertex-Based.cu" then compile and run it.   
 
