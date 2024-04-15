# Producer Consumer
- This project is a simple implementation of famous and entry level probelm of multithreading called producer-consumer problem using java.
## What is producer and consumer problem?
  - Main objective of this problem is to have a place called market which can be accessed by producer and consumer threads. 
  - Producer threads add their product into market and consumer threads consumer the existing products. 
  - Producer cannot add the product if market is full and there is no place to add the products.
  - Consumer cannot consume the product if the market is empty (assume the market as the storage)
  - For a healthy market both producers and consumers should do their tasks contineously.
  - The play of managing shared resource (market) is the main focus in this problem.