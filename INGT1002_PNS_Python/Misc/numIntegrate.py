import math
from numpy import *

N = 100
start = 0
stop = 4

def f(x):
    return x**2 + 1

def trap_integrate(f, start, stop, N):
    delta_x = (stop - start) / N
    result = 0
    
    for i in range(N):
        x = start + i*delta_x
        
        result += (f(x) + f(x + delta_x))*delta_x/2
    
    return result

def simpson(f, a, b, n=10):
# Find an approximation to an integral by the composite Simpson's method:
# Input:  
#   f:    integrand
#   a, b: integration interval
#   2*n:  number of subintervals
# Output: The approximation to the integral
    m = 2*n
    x_noder = linspace(a, b, m+1)       # equidistributed nodes from a to b 
    h = (b-a)/m                         # stepsize
    S1 = f(x_noder[0]) + f(x_noder[m])  # S1 = f(x_0)+f(x_{2n})
    S2 = sum(f(x_noder[1:m:2]))         # S2 = f(x_1)+f(x_3)+...+f(x_{2n-1})
    S3 = sum(f(x_noder[2:m-1:2]))       # S3 = f(x_2)+f(x_4)+...+f(x_{2n-2})
    S = h*(S1 + 4*S2 + 2*S3)/3
    return (m, S)


(m, S) = simpson(f, start, stop, n=1)   # Numerical solution, using 2*n subintervals   
#print(trap_integrate(f, start, stop, N))
print(S)