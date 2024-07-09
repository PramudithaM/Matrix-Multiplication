#EEX5335 – OPERATING SYSTEMS - LAB02

# MatrixMultiplicationSimulator

This repository contains two separate multithreaded programs for matrix multiplication:
1. Using Pthread API in C.
2. Using Java threads.

## Prerequisites

### For WSL (Windows Subsystem for Linux)
- Ensure you have WSL installed with a Linux distribution like Ubuntu.
- Install necessary tools (GCC for C, JDK for Java).

### Installing WSL (If not already installed)
1. Open PowerShell as Administrator and run:
    ```powershell
    wsl --install
    ```
2. Choose a Linux distribution, such as Ubuntu, and follow the on-screen instructions.

## Instructions to Run

### C Program with Pthreads

1. **Open WSL and Clone the Repository**:
    ```sh
    git clone https://github.com/yourusername/MatrixMultiplicationSimulator.git
    cd MatrixMultiplicationSimulator/C
    ```

2. **Install GCC (if not already installed)**:
    ```sh
    sudo apt update
    sudo apt install gcc
    ```

3. **Compile the Program**:
    ```sh
    gcc -pthread matrix_multiplication_pthreads.c -o matrix_multiplication_pthreads
    ```

4. **Run the Program**:
    ```sh
    ./matrix_multiplication_pthreads
    ```

### Java Program with Threads

1. **Open WSL and Clone the Repository**:
    ```sh
    git clone https://github.com/yourusername/MatrixMultiplicationSimulator.git
    cd MatrixMultiplicationSimulator/Java
    ```

2. **Install Java (if not already installed)**:
    ```sh
    sudo apt update
    sudo apt install default-jdk
    ```

3. **Compile the Program**:
    ```sh
    javac MatrixMultiplication.java
    ```

4. **Run the Program**:
    ```sh
    java MatrixMultiplication
    ```

## Repository Structure

