
import numpy as np
import skolebibliotek as sk

def halvering_solve(f, a,b, tol):
    
    #vars
    i = 0
    iterations = 10000
    
    low = a
    high = b
    mid = (low + high)/2
    
     
    
    while i < iterations and abs(f(mid)) > tol:
        if f(low) * f(mid) < 0:
            high = mid
        else:
            low = mid
            
        i += 1
        mid = (low+high)/2

    if abs(f(mid)) < tol:
        return mid
    else:
        return None

def f(x): 
    return 9 - x**3
    
a = 2
b = 3
maks_feil = 1E-8 #Hva blir maks feil om x_sol skal være riktig med minst 6 desimaler?

print(halvering_solve(f,a,b, maks_feil))
print(sk.bisection_method(f, a, b))