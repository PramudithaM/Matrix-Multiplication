#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#define MAX 3
int matA[MAX][MAX];
int matB[MAX][MAX];
int result[MAX][MAX];
struct thread_data
{
    int row;
    int col;
    int size;
};
void *mult(void *arg)
{
    struct thread_data *data = (struct thread_data *)arg;
    int row = data->row;
    int col = data->col;
    int size = data->size;
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        sum += matA[row][i] * matB[i][col];
    }

    result[row][col] = sum;

    pthread_exit(NULL);
}
int main()
{
    int r1, c1, r2, c2;
    // Input matrix dimensions
    printf("Enter the dimensions of matrix A (rows columns): ");
    scanf("%d %d", &r1, &c1);
    printf("Enter the dimensions of matrix B (rows columns): ");
    scanf("%d %d", &r2, &c2);
    if (c1 != r2)
    {
        printf("Matrix multiplication is not possible with these dimensions.\n");
        return 1;
    }
    // Input matrix elements for A
    printf("Enter the elements of matrix A:\n");
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c1; j++)
        {
            scanf("%d", &matA[i][j]);
        }
    }
    // Input matrix elements for B
    printf("Enter the elements of matrix B:\n");
    for (int i = 0; i < r2; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            scanf("%d", &matB[i][j]);
        }
    }
    // Initialize result matrix to 0
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            result[i][j] = 0;
        }
    }
    // Create threads for matrix multiplication
    pthread_t threads[MAX][MAX];
    struct thread_data data[MAX][MAX];
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            data[i][j].row = i;
            data[i][j].col = j;
            data[i][j].size = c1;
            pthread_create(&threads[i][j], NULL, mult, &data[i][j]);
        }
    }
    // Wait for threads to finish
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            pthread_join(threads[i][j], NULL);
        }
    }
    // Print the result matrix
    printf("Resultant Matrix:\n");
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }
    return 0;
}
