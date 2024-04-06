<h1 align="center" id="title">Singleton Thread Safe Implementation</h1>

<p id="description">In this code basically we are trying to achieve the thread safe Implementation the Thread Safe Implementation which basically means when we talk about thread we mean that we want this program to perform more than one task at the same time so when we are executing the multiple threads at the same time and if they all are sharing the same object or data structure then it can lead to the inconsistencies meaning if you run the same method in the multiple threads it will give you the different results and we want our results to be consistent. So we can prevents this racing of the multiple threads by using "synchronized" keyword what it does is that we add a synchronized keyword before declaring the type of function so what it will do is that when we run the code the java compiler will acquire a lock on the method and will know that which object this method belongs to which helps in ensuring that only one thread can execute that method. This helps in preventing the racing conditions and inconsistencies. if there are multiple threads who wants to execute the methods they have to wait then when their turn they java complier will run the method but will not allow multiple threads to execute the same method at the same time</p>



 <p>The Code is in Java and written in the ECLIPSE IDE</p>
 HELPFULL RESOURCES:  https://www.turing.com/kb/thread-safety-in-java-and-implementation

