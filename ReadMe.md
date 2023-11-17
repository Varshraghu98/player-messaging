A Java program where two players, each running in a separate process with different PIDs, engage in a messaging exchange. One player, termed the "initiator," initiates the communication by sending a message to the second player. Upon receiving a message, a player responds by sending back a new message that concatenates the received message with a message counter-specific to that player. The program is designed to gracefully conclude after the initiator successfully sends and receives 10 messages, establishing a stop condition for program finalization. This scenario necessitates considering inter-process communication mechanisms, such as sockets or messaging queues, to facilitate message exchange between the Java processes.

# How to Run

To run the application, follow these steps:

1. First, create a package by running the following Maven command to build the project. Make sure to skip tests.

    ```bash
    mvn package -Dmaven.test.skip=true
    ```

2. After successfully building the project, you can run the provided shell script (`start.sh`)

    ```bash
    ./start.sh
    ```

3. When the execution finishes, you can press any key to exit the application.

