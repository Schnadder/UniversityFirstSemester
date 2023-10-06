import numpy as np

def naive_gauss(A,b):
    n,m = np.shape(A)
    S = np.zeros((n,n+1))
    S[:,0:n] = A
    S[:,-1] = b
    for j in range(n-1):
      for i in range(j+1,n):
        mult = S[i,j]/S[j,j]
        print(mult)
        for k in range(j, n+1):
            S[i,k] -= S[j,k] * mult
        S[i,j] = 0.0
        
    x = S[:,-1]
    for i in range(n - 1,-1,-1): #Looping through from the bottom
        for j in range(i + 1, n):
            x[i] = x[i] - S[i, j] * x[j]
        x[i] = x[i] / S[i,i]

    return x
   
A = np.array([[1, 0, -1],
              [0, 16, 3],
              [-10, -3, 0]])
b = np.array([0, -16, -16])
x = naive_gauss(A,b)
print(x)
