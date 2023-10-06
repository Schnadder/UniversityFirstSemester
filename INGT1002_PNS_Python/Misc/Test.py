import numpy as np
A = np.array([[12, 7, 3], [1, 5, 1],[2,7,11]], dtype=float)
b=np.array([7, 22, -2], dtype=float)
x=np.array([0, 0, 0], dtype=float)
iterasjoner = 7
n = np.shape(A)[0]
for k in range(0,iterasjoner):
    for i in range(0,n):
        x[i] = b[i]
        for j in range(0,n):
            if i != j:
                x[i] = x[i] - A[i,j]*x[j]
        x[i] = x[i]/A[i,i]
    print(x)
   
   
print("Korrekt")
print(np.linalg.solve(A,b))